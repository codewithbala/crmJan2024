import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Candidate } from 'src/app/model/candidate';
import { CandidateBack } from 'src/app/model/candidate-back';
import { EndClient, Submission, Vendor } from 'src/app/model/submission';
import { CandidateService } from 'src/app/service/candidate-service';
import { SubmissionService } from 'src/app/service/submission.service';
import { RedirectController } from 'src/app/tools/redirect-controller';
import { RoleCheck } from 'src/app/tools/role-check';
import { ApiResponse, CountryRegionResponse } from 'src/models';
import CountryRegion from "countryregionjs";


@Component({
  selector: 'app-candidate-submissions',
  templateUrl: './candidate-submissions.component.html',
  styleUrls: ['./candidate-submissions.component.css']
})
export class CandidateSubmissionsComponent {



  role:string;
  candidateList:Candidate[]
  currentCandidate:Candidate;
  submission:Submission = new Submission();
  submissionId:string;
  submissionStatus=["Submitted","Placed","Declined"];

  addressCity:string = '';
  addressState:string = '';
  addressCountry:string = ''
  countries: CountryRegionResponse[] = [];
  states: CountryRegionResponse[] = [];
  lgas: CountryRegionResponse[] = [];
  countryRegion: any = null;
  ONE: number = 1;


  bsConfig = Object.assign({}, {dateInputFormat: 'YYYY-MM-DD', showWeekNumbers: false, showMouthNumber:true});
  constructor(private router:ActivatedRoute,private candidateService:CandidateService,private submissionService:SubmissionService,
     private route:Router, private redirectController:RedirectController, private roleCheck:RoleCheck)
  {}
  ngOnInit(){
    this.role = this.router.snapshot.params['role'];
    this.submissionId= this.router.snapshot.params['id'];
    console.log(this.role);
     // @ts-ignore
     let myAccount = JSON.parse( window.sessionStorage.getItem('SNVA_CRM_USER') );
    console.log(myAccount);

    this.getStates();

    this.candidateService.getAllCandidates().subscribe(data=>{
      this.candidateList = data;
      console.log(this.candidateList[0].candidateId);
      this.submission.bdeName = myAccount.userPersonalDetails.firstName;
      console.log(this.submission);
    })
    if(this.submissionId!=='new'){
      this.submissionService.getSubmission(this.submissionId).subscribe(data=>{
        this.submission=data;
        if(this.submission.endClient===null) this.submission.endClient=new EndClient;
        if(this.submission.vendor===null) this.submission.vendor=new Vendor;
      })
    }
    
  }

  add(submission: Submission) {
    const date = new Date().toISOString().slice(0, -5);
    submission.dateOfSubmission =date;
    console.log(submission);
    this.submissionService.saveSubmission(submission).subscribe(data=>{
      window.location.href = "user/check/submissions";
    })
    }
    save(submission: Submission) {
      const date = new Date().toISOString().slice(0, -5);
      submission.dateOfSubmission =date;
      console.log(submission);
      this.submissionService.putSubmission(submission).subscribe(data=>{
        console.log(data);
        window.location.href = "user/check/submissions";
      })
      }


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
          if (true)
          {
            const states = await this.getCountryRegionInstance()?.getStates(236);
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
          if (true && state) {
            const lgas = await this.getCountryRegionInstance()?.getLGAs(236, state.value);
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
        console.log(this.addressState)
        this.getLGAs();
      }
      handleLgaChange():void{
        this.addressCity = (document.getElementById("addressCity") as HTMLSelectElement).value;
        console.log(this.addressCity)
        this.submission.vendor.city=this.addressCity;
        this.submission.vendor.state =this.addressState;
      }
      handleEQStateChange(): void
      {
        this.addressState = (document.getElementById("addressEQState") as HTMLSelectElement).value;
        console.log(this.addressState)
        this.getLGAs();
      }
      handleEQLgaChange():void{
        this.addressCity = (document.getElementById("addressEQCity") as HTMLSelectElement).value;
        console.log(this.addressCity)
        this.submission.endClient.city=this.addressCity;
        this.submission.endClient.state =this.addressState;
      }
    

}
