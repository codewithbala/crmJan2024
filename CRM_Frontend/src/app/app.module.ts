import { NgModule } from '@angular/core';

import { BrowserModule } from '@angular/platform-browser';
import { NgParticlesModule } from 'ng-particles';
import { NgConfettiModule } from 'ng-confetti';
import { NgFireworksModule } from 'ng-fireworks';
import { ModalModule } from 'ngx-bootstrap/modal';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';

import { AppComponent } from './app.component';
import { AppRoutingModule } from './app-routing.module';
import { LogInView } from './view/logIn/logInView';
import { AccountListView } from './view/accountList/accountListView';
import { AccountDetailView } from './view/accountDetail/accountDetailView';
import { CandidateListView } from './view/candidateList/candidateListView';
import { CandidateDetailView } from './view/candidateDetail/candidateDetailView';
import { HomePageView } from './view/homePage/homePageView';
import { HeaderComponent } from './view/nav/header/header.component';
import { FooterComponent } from './view/nav/footer/footer.component';
import { DeleteUserConfirmView } from './view/popView/deleteUserConfirmView/deleteUserConfirmView';
import { ResponeMessage } from './view/popView/responeMessage/responeMessage';
import { HTTP_INTERCEPTORS, HttpClientModule } from '@angular/common/http';
import { RouterOutlet } from '@angular/router';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AddNewUser } from './view/popView/addNewUser/addNewUser';
import { HttpInterceptorService } from './service/http-interceptor.service';
import { BsDatepickerModule, BsDatepickerConfig } from 'ngx-bootstrap/datepicker';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { GotoCandidateListConfirmView } from './view/popView/gotoCandidateListConfirmView/gotoCandidateListConfirmView';
import { MenuBar } from './view/accountDetail/menuBar/menuBar';
import { MenuBarReadOnly } from './view/accountDetail/menuBarReadOnly/menuBarReadOnly';
import { ErrorPage } from './view/accountDetail/errorPage/errorPage';
import { AccountInfo } from './view/accountDetail/accountInfo/accountInfo';
import { AccountInfoReadOnly } from './view/accountDetail/accountInfoReadOnly/accountInfoReadOnly';
import { CanSuspend } from './view/accountDetail/canSuspend/canSuspend';

// Pipe
import { SNVApipeStringCutOff     } from "./tools/SNVApipeStringCutOff";
import { SNVApipeGetAccountRole   } from "./tools/SNVApipeGetAccountRole";
import { SNVApipeGetAccountStatus } from "./tools/SNVApipeGetAccountStatus";
import { BackgroundComponent } from './view/background/background.component';
import { CadidateRecruiterDetailViewComponent } from './view/cadidate-recruiter-detail-view/cadidate-recruiter-detail-view.component';
import { PhoneNumber } from './view/accountDetail/phoneNumber/phoneNumber';
import { PasswordComponent } from './view/accountDetail/password/password.component';
import { AddressComponent } from './view/accountDetail/address/address.component';
import { CandidateTechViewComponent } from './view/candidate-tech-view/candidate-tech-view.component';
import { CandidateBDViewComponent } from './view/candidate-bdview/candidate-bdview.component';
import { CandidateSubmissionsComponent } from './view/candidate-submissions/candidate-submissions.component';
import { ViewAllSubmissionsComponent } from './view/view-all-submissions/view-all-submissions.component';


import { UpdateUI } from "./view/updateUI/view/updateUI"
import { HtmlElementStyleConfigureView } from "./view/updateUI/view/htmlElementStyleConfigure/htmlElementStyleConfigureView";
import { HtmlElementTextFontConfigureView } from './view/updateUI/view/htmlElementStyleConfigure/UnitConfigureView/htmlElementTextFontConfigureView/htmlElementTextFontConfigureView';
import { HtmlElementTextPositionConfigureView } from './view/updateUI/view/htmlElementStyleConfigure/UnitConfigureView/htmlElementTextPositionConfigureView/htmlElementTextPositionConfigureView';
import { HtmlElementBoxPositionConfigureView } from './view/updateUI/view/htmlElementStyleConfigure/UnitConfigureView/htmlElementBoxPositionConfigureView/htmlElementBoxPositionConfigureView';
import { HtmlElementBoxBorderConfigureView } from './view/updateUI/view/htmlElementStyleConfigure/UnitConfigureView/htmlElementBoxBorderConfigureView/htmlElementBoxBorderConfigureView';
import { HtmlElementBoxColorConfigureView } from './view/updateUI/view/htmlElementStyleConfigure/UnitConfigureView/htmlElementBoxColorConfigureView/htmlElementBoxColorConfigureView';
import { HtmlElementBoxShadowConfigureView } from './view/updateUI/view/htmlElementStyleConfigure/UnitConfigureView/htmlElementBoxShadowConfigureView/htmlElementBoxShadowConfigureView';
import { HtmlElementTextShadowConfigureView } from './view/updateUI/view/htmlElementStyleConfigure/UnitConfigureView/htmlElementTextShadowConfigureView/htmlElementTextShadowConfigureView';
import { HtmlElementPreView } from './view/updateUI/view/htmlElementPreView/htmlElementPreView';
import { HtmlElementListView } from './view/updateUI/view/htmlElementListView/htmlElementListView';



@NgModule({
    declarations: [
        AppComponent,
        LogInView,
        AccountListView,
        AccountDetailView,
        CandidateListView,
        CandidateDetailView,
        HomePageView,
        HeaderComponent,
        FooterComponent,
        DeleteUserConfirmView,
        ResponeMessage,
        AddNewUser,
        AddNewUser,
        GotoCandidateListConfirmView,
        MenuBar,
        MenuBarReadOnly,
        ErrorPage,
        AccountInfo,
        AccountInfoReadOnly,

        SNVApipeStringCutOff,
        SNVApipeGetAccountRole,
        SNVApipeGetAccountStatus,
        CanSuspend,
        BackgroundComponent,
        CadidateRecruiterDetailViewComponent,
        PhoneNumber,
        PasswordComponent,
        AddressComponent,
        CandidateTechViewComponent,
        CandidateBDViewComponent,
        CandidateSubmissionsComponent,

        ViewAllSubmissionsComponent


        UpdateUI,
        HtmlElementStyleConfigureView,
        HtmlElementTextFontConfigureView,
        HtmlElementTextPositionConfigureView,
        HtmlElementBoxPositionConfigureView,
        HtmlElementBoxBorderConfigureView,
        HtmlElementBoxColorConfigureView,
        HtmlElementBoxShadowConfigureView,
        HtmlElementTextShadowConfigureView,
        HtmlElementPreView,
        HtmlElementListView

    ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    RouterOutlet,
    FormsModule,
    ModalModule.forRoot(),
    NgbModule,
    NgParticlesModule,
    NgConfettiModule,
    NgFireworksModule,
    BsDatepickerModule.forRoot(),
    BrowserAnimationsModule,
    ReactiveFormsModule
  ],
  providers: [{
    provide: HTTP_INTERCEPTORS,
    useClass: HttpInterceptorService,
    multi: true}],
  bootstrap: [AppComponent]
})
export class AppModule { }
