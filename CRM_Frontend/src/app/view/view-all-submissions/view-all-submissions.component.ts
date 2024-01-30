import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Submission } from 'src/app/model/submission';
import { SubmissionService } from 'src/app/service/submission.service';
import { RoleCheck } from 'src/app/tools/role-check';

@Component({
  selector: 'app-view-all-submissions',
  templateUrl: './view-all-submissions.component.html',
  styleUrls: ['./view-all-submissions.component.css']
})
export class ViewAllSubmissionsComponent {


  addCandidateRight:boolean;
  submissions:Submission[];
  role:string;
  constructor(private submissionService:SubmissionService,private route:Router, private roleCheck:RoleCheck,private router:ActivatedRoute){}
ngOnInit(){
  this.role = this.router.snapshot.params['user'];
  this.addCandidateRight = true;
  this.submissionService.getAllSubmissions().subscribe(data=>{
    this.submissions=data;
    console.log(this.submissions)
  })
}
showAddNewSubmission() {
  window.location.href = "user/check/submission/new";
  }
  showSubmissionDetail(id: number) {
    window.location.href = "user/check/submission/"+id;
  }
}
