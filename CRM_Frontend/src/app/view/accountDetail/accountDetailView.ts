import {Component, OnInit} from '@angular/core';
import {User} from "../../model/user";
import {ActivatedRoute} from "@angular/router";
import {AccountService} from "../../service/account.service";
import {InputCheck} from "../../tools/input-check";
import {RedirectController} from "../../tools/redirect-controller";
import {RoleCheck} from "../../tools/role-check";
import {BsModalRef, BsModalService} from "ngx-bootstrap/modal";

import { FormControl, FormGroup } from '@angular/forms';
import CountryRegion from 'countryregionjs'
import { CountryRegionResponse } from 'src/models';
import { ApiResponse } from 'src/models';

@Component({
  selector: 'app-account-detail-view',
  templateUrl: './accountDetailView.html',
  styleUrls: ['./accountDetailView.css']
})
export class AccountDetailView implements OnInit
{
  userId:any = 1;
  currentUser:User = new User();
  currentUserRole:string = '';
  currentUserStatus:string = 'Suspend';
  currentStatus:string = '';
  authorization:string = '';
  canSuspend:boolean = false;
  inputCheck:InputCheck = new InputCheck();
  isMyAccount:boolean = false;
  addressCity:string = '';
  addressState:string = '';
  addressCountry:string = ''
   bsModalRef: BsModalRef;

  constructor(private router:ActivatedRoute, private modalService: BsModalService, private accountService:AccountService, private redirectController:RedirectController, private roleCheck:RoleCheck)
  {
    this.countryForm = new FormGroup({
      country: new FormControl(''),
      state: new FormControl(''),
      lga: new FormControl('')
    });
  }

  ngOnInit(): void
  {
    this.userId = this.router.snapshot.params['id'];
    this.loadStatus();
    // @ts-ignore
    let myAccount = JSON.parse( window.sessionStorage.getItem('SNVA_CRM_USER') );
    if(this.userId == 'myAccount' || this.userId == myAccount.userId)
    {
      this.currentUser =  myAccount;
      this.authorization = "readAndWrite";
      this.canSuspend = false;
      this.currentUserRole = this.roleCheck.getFrontendRoleName(this.currentUser.role);
      this.currentUserStatus = this.roleCheck.getUserStatus(this.currentUser.accountNonLocked);
      this.isMyAccount = true;
      this.loadCountryStateCity();
    }
    else
    {
      this.accountService.getUserById(this.userId).subscribe(
        data=>
        {
          this.currentUser = data;
          this.authorization = this.roleCheck.updateAccountCheck(myAccount.role, this.currentUser.role);
          this.canSuspend = this.roleCheck.deleteAccountCheck(myAccount.role, this.currentUser.role);
          this.currentUserRole = this.roleCheck.getFrontendRoleName(this.currentUser.role);
          this.currentUserStatus = this.roleCheck.getUserStatus(this.currentUser.accountNonLocked);
          this.isMyAccount = false;
          if(this.authorization == "readAndWrite")
          {
            this.loadCountryStateCity();
          }
          },
        error => {
          // @ts-ignore
          document.getElementById("loadDateError").innerHTML = "Can Not Load Account Information<br>Please Try Again";
        }
      )
    }

  }

  loadCountryStateCity()
  {
    this.addressCountry = this.currentUser.addressCountry;
    this.addressState   = this.currentUser.addressState;
    this.addressCity    = this.currentUser.addressCity;
    this.getCountries();
    this.getStates();
    this.getLGAs();
  }
  changeStatus( status:string )
  {
    this.currentStatus = status;
    if(status == 'mailAddress')
    {
      this.loadCountryStateCity();
    }
  }
  loadStatus()
  {
    let status = localStorage.getItem('SNVA_CRM_AccountDetail');
    if(status != null)
    {
      this.currentStatus = status;
      localStorage.removeItem('SNVA_CRM_AccountDetail');
    }
    else
    {
      this.currentStatus = "accountInfo";
    }

  }
  saveStatus()
  {
    localStorage.setItem('SNVA_CRM_AccountDetail', this.currentStatus);
  }
  updatePhone():void
  {
    (document.getElementById('errorMessage') as HTMLInputElement).innerHTML = '';
    let newPhone = (document.getElementById('newPhone') as HTMLInputElement).value;
    let check = this.inputCheck.isPhoneNumber(newPhone);
    if(check == 'yes')
    {
      this.currentUser.phone = newPhone;
      this.accountService.updateUser(this.currentUser).subscribe(
      data =>
      {
        if(this.isMyAccount = true)
        {
          window.sessionStorage.setItem("SNVA_CRM_USER", JSON.stringify(this.currentUser));
        }
        this.redirectController.redirect("Update Phone Number Successful", '', '', 'auto');
        this.saveStatus();
      },
      error =>
      {
        this.redirectController.redirect("Update Phone Number Failed", error.message, '', 'auto');
        this.saveStatus();
      });
    }
    else
    {
      (document.getElementById('errorMessage') as HTMLInputElement).innerHTML =
        '<div class="card cardBackGround border-danger text-danger">' + check + '</div>'
    }
  }
  updateAddress():void
  {
    (document.getElementById('errorMessage') as HTMLInputElement).innerHTML = '';
    let addressLine1    = (document.getElementById("addressLine1"  ) as HTMLInputElement).value;
    let addressLine2    = (document.getElementById("addressLine2"  ) as HTMLInputElement).value;
    let addressZipCode  = (document.getElementById("addressZipCode") as HTMLInputElement).value;
    this.addressCountry = (document.getElementById("addressCountry") as HTMLSelectElement).value;
    this.addressState   = (document.getElementById("addressState"  ) as HTMLSelectElement).value;
    this.addressCity    = (document.getElementById("addressCity"   ) as HTMLSelectElement).value;

    let check = this.inputCheck.isAddress(addressLine1, addressLine2, this.addressCountry, this.addressState, this.addressCity, addressZipCode);
    if(check == 'yes')
    {
      this.currentUser.addressCountry = this.addressCountry;
      this.currentUser.addressState   = this.addressState;
      this.currentUser.addressCity    = this.addressCity;
      this.currentUser.addressLine1   = addressLine1;
      this.currentUser.addressLine2   = addressLine2;
      this.currentUser.addressZipCode = addressZipCode;
      this.accountService.updateUser(this.currentUser).subscribe(
        data =>
        {
          if(this.isMyAccount == true)
          {
            window.sessionStorage.setItem("SNVA_CRM_USER", JSON.stringify(this.currentUser));
          }
          this.redirectController.redirect("Update Address Successful", '', '', 'auto');
          this.saveStatus();
        },
        error =>
        {
          this.redirectController.redirect("Update Address Failed", error.message, '', 'auto');
          this.saveStatus();
        });
    }
    else
    {
      (document.getElementById('errorMessage') as HTMLInputElement).innerHTML =
        '<div class="card cardBackGround border-danger text-danger">' + check + '</div>'
    }
  }
  resetPassword():void
  {
    (document.getElementById('errorMessage') as HTMLInputElement).innerHTML = '';
    let check:string = "yes";
    // check original password.
    if(this.isMyAccount == true)
    {
      let originalPassword = (document.getElementById("originalPassword") as HTMLInputElement).value
      // @ts-ignore
      let myAccount = JSON.parse( window.sessionStorage.getItem('SNVA_CRM_USER') );
      if(originalPassword == myAccount.password)
      {
        check = 'yes';
      }
      else
      {
        check = "Wrong Original Password"
      }
    }
    console.log("check original:" + check)

    // check password format.
    let newPassword     = (document.getElementById("newPassword"    ) as HTMLInputElement).value
    if(check == 'yes')
    {
      check = this.inputCheck.isPassword(newPassword);
      console.log("check password:" + check);
    }

    // check confirm password
    if(check == 'yes')
    {
      let confirmPassword = (document.getElementById("confirmPassword") as HTMLInputElement).value
      if(confirmPassword != newPassword)
      {
        check = "confirm password does not match"
      }
    }

    console.log("check confirm:" + check);
    if(check == 'yes')
    {
      this.currentUser.password = newPassword;
      this.accountService.resetPassword(this.currentUser).subscribe(
        data =>
        {
          if(this.isMyAccount == true)
          {
            window.sessionStorage.setItem("SNVA_CRM_USER", JSON.stringify(this.currentUser));
          }
          this.redirectController.redirect("Reset Password Successful", '', '', 'auto');
          this.saveStatus();
        },
        error =>
        {
          this.redirectController.redirect("Reset Password Failed", error.message, '', 'auto');
          this.saveStatus();
        });
    }
    else
    {
      (document.getElementById('errorMessage') as HTMLInputElement).innerHTML =
        '<div class="card cardBackGround border-danger text-danger">' + check + '</div>'
    }
  }


  /************ country status city **************/
  countryForm: FormGroup;
  countryRegion: any = null;
  countries: CountryRegionResponse[] = [];
  states: CountryRegionResponse[] = [];
  lgas: CountryRegionResponse[] = [];
  ONE: number = 1;

  getCountryRegionInstance = () =>
    this.countryRegion ??= new CountryRegion();

  async getCountries(): Promise<void> {
    try {
      const countries = await this.getCountryRegionInstance()?.getCountries();
      this.countries = countries.map((country: ApiResponse, index: number) => ({
        value: index + this.ONE,
        label: country.name,
      }));

    } catch (error) {
      console.error(error);
    }
  }

  async getStates(): Promise<void> {
    try {
      const country = this.countries.find(o => o.label == this.addressCountry);
      console.log("###state:")
      console.log(country);
      if (country)
      {
        const states = await this.getCountryRegionInstance()?.getStates(country.value);
        this.states = states.map((userState: ApiResponse, index: number) => ({
          value: index + this.ONE,
          label: userState?.name
        }));
      }

    } catch (error) {
      console.error(error);
    }
  }

  async getLGAs(): Promise<void> {
    try
    {
      const country = this.countries.find(o => o.label == this.addressCountry);
      const state = this.states.find(o => o.label == this.addressState);
      console.log("###city:")
      console.log(country);
      console.log(state);
      if (country && state) {
        const lgas = await this.getCountryRegionInstance()?.getLGAs(country.value, state.value);
        this.lgas = lgas?.map((lga: ApiResponse, index: number) => ({
          value: index + this.ONE,
          label: lga?.name
        }));
      }
    } catch (error) {
      console.error(error);
    }
  }

  handleCountryChange(): void
  {
    this.addressCountry = (document.getElementById("addressCountry") as HTMLSelectElement).value;
    this.getStates();
  }

  handleStateChange(): void
  {
    this.addressState = (document.getElementById("addressState") as HTMLSelectElement).value;
    this.getLGAs();
  }

}
