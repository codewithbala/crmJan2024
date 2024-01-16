import {Component, OnInit} from '@angular/core';
import { ActivatedRoute, Route, Router } from '@angular/router';
import { CandidateService } from 'src/app/service/candidate-service';
import { CandidateBack } from 'src/app/model/candidate-back';
import {BsDatepickerConfig} from "ngx-bootstrap/datepicker";
import {MenuData} from "../../data/menuData";
import {ApiResponse, CountryRegionResponse} from "../../../models";
import CountryRegion from "countryregionjs";
import {RoleCheck} from "../../tools/role-check";
import {RedirectController} from "../../tools/redirect-controller";
import {InputCheck} from "../../tools/input-check";

@Component({
  selector: 'app-candidate-detail-view',
  templateUrl: './candidateDetailView.html',
  styleUrls: ['./candidateDetailView.css']
})
export class CandidateDetailView implements OnInit
{
  bsConfig: Partial<BsDatepickerConfig>;
  menuData:MenuData = new MenuData();
  inputCheck:InputCheck = new InputCheck();
  pageStatus:string = "recruiter";
  candidateId:string="";
  currentCandidate:CandidateBack = new CandidateBack();

  workExpYear:number = 0;
  workExpMouth:number = 0;
  addressCity:string = '';
  addressState:string = '';
  addressCountry:string = ''

  loiSent     = 'No'
  loiAccepted = 'No'
  joinedBatch = 'No'

  candidateP1Right:boolean = false;
  candidateP2Right:boolean = false;
  candidateP3Right:boolean = false;

  constructor(private router:ActivatedRoute,private candidateService:CandidateService, private route:Router, private redirectController:RedirectController, private roleCheck:RoleCheck)
  {
  }
  ngOnInit(): void
  {
    this.candidateId = this.router.snapshot.params['id'];
    this.bsConfig = Object.assign({}, {dateInputFormat: 'YYYY-MM-DD', showWeekNumbers: false});
    // @ts-ignore
    let myAccount = JSON.parse( window.sessionStorage.getItem('SNVA_CRM_USER') );
    if(this.candidateId == 'new')
    {
      this.candidateService.setNextCandidateId().subscribe(
        data=>
        {
          this.currentCandidate.candidateId=data.candidateId;
          this.currentCandidate.recruiterName = myAccount.firstName + " " + myAccount.lastName;
          this.candidateP1Right = this.roleCheck.updateCandidateP1Check(myAccount.role);
          this.getCountries();
        })
    }
    else
    {
      this.candidateService.getCandidate(this.candidateId).subscribe(
        data=>
        {
        this.currentCandidate=data;
        this.candidateP1Right = this.roleCheck.updateCandidateP1Check(myAccount.role);
        this.candidateP2Right = this.roleCheck.updateCandidateP2Check(myAccount.role);
        this.candidateP3Right = this.roleCheck.updateCandidateP3Check(myAccount.role);
          if(data.details.LOISent)
          {
            this.loiSent = 'Yes';
          }
          if(data.details.joinedBatch)
          {
            this.joinedBatch  = 'Yes';
          }
          if(data.details.LOIAccepted)
          {
            this.loiAccepted= 'Yes';
          }
        if(this.candidateP1Right == true)
        {
          this.workExpYear  = parseInt(data.workExperience.substring(0,data.workExperience.indexOf('year(s)')));
          this.workExpMouth = parseInt(data.workExperience.substring(data.workExperience.indexOf(')')+2,data.workExperience.indexOf('mouth(s)')));
          this.addressCountry = data.details.addressCounty;
          this.addressState = data.details.addressState;
          this.addressCity = data.details.addressCity;
          this.getCountries();
          this.getStates();
          this.getLGAs();
          this.bsConfig = Object.assign({}, {dateInputFormat: 'YYYY-MM-DD', showWeekNumbers: false, showMouthNumber:true});
        }
        else
        {
          if(this.candidateP2Right || this.candidateP3Right)
          {
            this.pageStatus = 'techBD';
          }
        }
      })
    }

  }

  add(candidate:CandidateBack)
  {
    (document.getElementById('errorMessage') as HTMLInputElement).innerHTML = '';
    candidate.workExperience = this.workExpYear + ' year(s) ' + this.workExpMouth + ' mouth(s)';
    candidate.details.interviewDate = (document.getElementById('interviewDate') as HTMLInputElement).value;
    candidate.details.addressCounty = (document.getElementById('addressCountry') as HTMLInputElement).value;
    candidate.details.addressState  = (document.getElementById('addressState') as HTMLInputElement).value;
    candidate.details.addressCity   = (document.getElementById('addressCity') as HTMLInputElement).value;
    let check:string = this.checkForm(candidate);
    if(check == 'yes')
    {
      console.log(candidate);
      this.candidateService.saveCandidate(candidate).subscribe(data=>
      {
        // @ts-ignore
        let myAccount = JSON.parse( window.sessionStorage.getItem('SNVA_CRM_USER') );
        this.redirectController.redirect("Add Candidate Successful", '', this.roleCheck.getFrontendRoleType(myAccount.role) + '/manage/candidate');
      },
        error =>
      {
          this.redirectController.redirect("Add Candidate Successful", error.message, '');
      })
    }
    else
    {
      (document.getElementById('errorMessage') as HTMLInputElement).innerHTML =
        '<div class="card cardBackGround border-danger text-danger text-center">' + check + '</div>'
    }
  }


  save(candidate:CandidateBack)
  {
    (document.getElementById('errorMessage') as HTMLInputElement).innerHTML = '';
    let check:string = 'yes';

    if(this.candidateP1Right == true)
    {
      candidate.workExperience = this.workExpYear + ' year(s) ' + this.workExpMouth + ' mouth(s)';
      let interviewDate = (document.getElementById('interviewDate') as HTMLInputElement).value;
      if(interviewDate != "")
      {
        candidate.details.interviewDate = interviewDate;
      }
      candidate.details.addressCounty = (document.getElementById('addressCountry') as HTMLInputElement).value;
      candidate.details.addressState  = (document.getElementById('addressState') as HTMLInputElement).value;
      candidate.details.addressCity   = (document.getElementById('addressCity') as HTMLInputElement).value;
      check = this.checkForm(candidate);
    }

    if(this.candidateP2Right == true)
    {
       if(candidate.details.interviewerFeedback == '')
       {
         check = 'Interview Feedback is Empty';
       }

      if(candidate.details.candidateInterviewStatus == '')
      {
        check = 'Please Choose Candidate Status';
      }
    }

    if(this.candidateP3Right == true)
    {
      let loiSent     = (document.getElementById("loiSent"    ) as HTMLSelectElement).value;
      let loiAccepted = (document.getElementById("loiAccepted") as HTMLSelectElement).value;
      let joinedBatch = (document.getElementById("joinBatch"  ) as HTMLSelectElement).value;
      let batchStartDate = (document.getElementById('batchStartDate') as HTMLInputElement).value;
      candidate.details.startDate = batchStartDate;

      if(loiSent == this.menuData.LOI_SENT[0])
      {
        candidate.details.LOISent = true;
      }
      else
      {
        candidate.details.LOISent = false;
      }

      if(loiAccepted == this.menuData.LOI_ACCEPTED[0])
      {
        candidate.details.LOIAccepted = true;
      }
      else
      {
        candidate.details.LOIAccepted = false;
      }

      if(joinedBatch == this.menuData.JOIN_BATCH[0])
      {
        candidate.details.joinedBatch = true;
      }
      else
      {
        candidate.details.joinedBatch = false;
      }


      if(candidate.details.joinedBatch == true && candidate.details.startDate == '')
      {
        check = 'Please Choose a Batch Start Date';
      }
    }

    if(check == 'yes')
    {
      console.log(candidate);
      this.candidateService.updateCandidate(candidate).subscribe(
        data=>
        {
          this.redirectController.redirect(data.toString(), '', '');
        },
        error =>
        {
          this.redirectController.redirect("Update Candidate Failed",error.message, '');
        })
    }
    else
    {
      (document.getElementById('errorMessage') as HTMLInputElement).innerHTML =
        '<div class="card cardBackGround border-danger text-danger text-center">' + check + '</div>'
    }
  }

  checkForm(candidate:CandidateBack)
  {
    let check = 'yes'
    check = this.inputCheck.isfullName(candidate.firstName, candidate.lastName);
    if(check != 'yes')
    {
      return check;
    }

    if(candidate.school == '')
    {
      return "School is Empty"
    }

    if(candidate.degree == '')
    {
      return "degree is Empty"
    }

    if(candidate.visaStatus == '')
    {
      return "Please Choose Visa Status"
    }

    if(candidate.ssn == '')
    {
      return "Please input Candidate's SSN, if he/she doesn't have SSN, Please input 0";
    }

    check = this.inputCheck.isEmailID(candidate.email);
    if(check != 'yes')
    {
      return check;
    }

    check = this.inputCheck.isPhoneNumber(candidate.phoneNumber);
    if(check != 'yes')
    {
      return check;
    }

    check = this.inputCheck.isAddress(candidate.details.addressLine1, candidate.details.addressLine2, candidate.details.addressCounty, candidate.details.addressState, candidate.details.addressCity, candidate.details.addressZipCode);
    if(check != 'yes')
    {
      return check;
    }

    if(candidate.details.skillSet == '')
    {
      return "Skill Set is Empty"
    }

    if(candidate.details.interviewDate == '' || candidate.details.interviewDate == 'yyyy-mm-dd')
    {
      return "Please Choose InterView Date";
    }

    if(candidate.details.interviewer == '')
    {
      return "Please Set an Interviewer";
    }

    return check;
  }


  onFileSelected(event: any, field: string) {
    const selectedFile = event.target.files[0];

    // Depending on the field parameter, assign the selected file to the corresponding property
    // if (field === 'resume') {
    //   this.candidate.resume = selectedFile;
    // } else if (field === 'otherFile') {
    //   this.candidate.otherFile = selectedFile;
    // }
  }

  chanegStatus(s:string)
  {
    this.pageStatus = s;
  }

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
