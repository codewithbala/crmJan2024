import {Component, Input, OnInit} from '@angular/core';
import { Router } from '@angular/router';
import {RoleCheck} from "../../../tools/role-check";
import {AddNewUser} from "../../popView/addNewUser/addNewUser";
import {BsModalService} from "ngx-bootstrap/modal";
import {UIconfigure} from "../../../config/UIconfigure";
import {UiModel} from "../../updateUI/model/uiModel";

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit
{
  @Input() title:any;
  @Input() userID:any;
  @Input() userName: any;
  @Input() userRole: any;

  @Input() model:string;
  @Input() ui:UiModel[];

  canAddAccount:boolean = false;
  canSeeAccount:boolean = false;
  addCandidate:boolean  = false;
  addSubmission:boolean  = false;

  constructor(private router:Router, private modalService: BsModalService, private roleCheck:RoleCheck, public uiconfigure:UIconfigure)
  {
    this.ui = this.uiconfigure.header;
  }

  ngOnInit(): void
  {
    // @ts-ignore
    let myAccount = JSON.parse( window.sessionStorage.getItem('SNVA_CRM_USER') );
    this.canAddAccount = this.roleCheck.addAccountCheck(myAccount.role);
    this.addCandidate  = this.roleCheck.addCandidateCheck(myAccount.role);
    this.canSeeAccount = this.roleCheck.seeAccountCheck(myAccount.role);
    this.addSubmission = this.roleCheck.addSubmissionCheck(myAccount.role);
  }

  logout()
  {
    window.sessionStorage.removeItem("SNVA_CRM_USER");
    window.location.href = "login";
  }

  myAccount()
  {
    window.location.href = this.roleCheck.getFrontendRoleType(this.userRole) + "/check/user/detail/myAccount";
  }
  accountlist()
  {
    window.location.href = this.roleCheck.getFrontendRoleType(this.userRole) + "/manage/user";
  }

  candidatelist()
  {
    window.location.href = this.roleCheck.getFrontendRoleType(this.userRole) + "/manage/candidate";
  }

  viewSubmission()
  {
    window.location.href = this.roleCheck.getFrontendRoleType(this.userRole) + "/check/submissions";
  }

  goDashboard()
  {
    window.location.href = this.roleCheck.getFrontendRoleType(this.userRole) + "/homepage";
  }

  showAddNewUser()
  {
    this.modalService.show(AddNewUser, {class: 'modal-md popBox-h'});
  }

  newCandidate()
  {
    window.location.href = this.roleCheck.getFrontendRoleType(this.userRole) + "/check/candidate/detail/new";
  }
}
