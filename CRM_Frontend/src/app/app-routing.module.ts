import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { LogInView } from './view/logIn/logInView';

import {AccountListView} from "./view/accountList/accountListView";
import {AccountDetailView} from "./view/accountDetail/accountDetailView";
import {CandidateListView} from "./view/candidateList/candidateListView";
import {CandidateDetailView} from "./view/candidateDetail/candidateDetailView";
import { HomePageView } from './view/homePage/homePageView';
import { CandidateSubmissionsComponent } from './view/candidate-submissions/candidate-submissions.component';
import { ViewAllSubmissionsComponent } from './view/view-all-submissions/view-all-submissions.component';
import {UpdateUI} from "./view/updateUI/view/updateUI";

const routes: Routes = [

  // For Log In, without Login
  {path:"login"                            , component:LogInView               },

  // HomePage Dashboard
  {path:":role/homepage"                   , component:HomePageView            },

  // For Admin, SuperAdmin
  {path:":role/manage/user"                , component:AccountListView         },
  {path:":role/check/user/detail/:id"      , component:AccountDetailView       },

  // For All Account
  {path:":role/manage/candidate"           , component:CandidateListView       }, // TODO
  {path:":role/check/candidate/detail/:id" , component:CandidateDetailView     }, // TODO

  {path:":role/check/submission/:id" , component:CandidateSubmissionsComponent     }, // TODO
  {path:":role/check/submissions" , component:ViewAllSubmissionsComponent     }, // TODO

  // For Update UI
  {path:"uiConfigure"                      , component:UpdateUI          }, // TODO

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule
{
}
