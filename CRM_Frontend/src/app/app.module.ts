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
import { TestComponent } from './view/test/test.component';
import { HeaderComponent } from './view/nav/header/header.component';
import { FooterComponent } from './view/nav/footer/footer.component';
import { DeleteUserConfirmView } from './view/popView/deleteUserConfirmView/deleteUserConfirmView';
import { ResponeMessage } from './view/popView/responeMessage/responeMessage';
import { HTTP_INTERCEPTORS, HttpClientModule } from '@angular/common/http';
import { RouterOutlet } from '@angular/router';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import {StringCutOffPipe} from "./tools/string-cut-off-pipe";
import { AddNewUser } from './view/popView/addNewUser/addNewUser';
import { HttpInterceptorService } from './service/http-interceptor.service';
import { BsDatepickerModule, BsDatepickerConfig } from 'ngx-bootstrap/datepicker';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

@NgModule({
    declarations: [
        AppComponent,
        LogInView,
        AccountListView,
        AccountDetailView,
        CandidateListView,
        CandidateDetailView,
        HomePageView,
        TestComponent,
        HeaderComponent,
        FooterComponent,
        DeleteUserConfirmView,
        ResponeMessage,
        AddNewUser,
        StringCutOffPipe,
        AddNewUser
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
