import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Candidate } from 'src/app/model/candidate';
import { CandidateBack } from 'src/app/model/candidate-back';
import { EndClient, Submission, Vendor } from 'src/app/model/submission';
import { CandidateService } from 'src/app/service/candidate-service';
import { SubmissionService } from 'src/app/service/submission.service';
import { RedirectController } from 'src/app/tools/redirect-controller';
import { RoleCheck } from 'src/app/tools/role-check';

@Component({
  selector: 'app-candidate-submissions',
  templateUrl: './candidate-submissions.component.html',
  styleUrls: ['./candidate-submissions.component.css']
})
export class CandidateSubmissionsComponent {

handleStateChange() {

}
handleCountryChange() {
}

  role:string;
  candidateList:Candidate[]
  currentCandidate:Candidate;
  submission:Submission = new Submission();
  submissionId:string;
  submissionStatus=["Submitted","Placed","Declined"];
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
        window.location.href = "user/check/submissions";
      })
      }
}
