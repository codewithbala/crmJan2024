import { Component, EventEmitter, Input, Output } from '@angular/core';
import { CandidateBack } from 'src/app/model/candidate-back';
import {MenuData} from "../../data/menuData";
import { CandidateService } from 'src/app/service/candidate-service';
import { CandidateAttachments } from 'src/app/model/candidate-attachments';
import { HttpEventType } from '@angular/common/http';
import { saveAs } from 'file-saver';
import { BsDatepickerConfig } from 'ngx-bootstrap/datepicker';
import { RedirectController } from 'src/app/tools/redirect-controller';
import { RoleCheck } from 'src/app/tools/role-check';

@Component({
  selector: 'app-candidate-recruiter-detail',
  templateUrl: './cadidate-recruiter-detail-view.component.html',
  styleUrls: ['./cadidate-recruiter-detail-view.component.css']
})
export class CadidateRecruiterDetailViewComponent {
  menuData:MenuData = new MenuData();
  file:File;

  isPdfResume:Boolean = true
  isPdfFile:Boolean = true
  attachments:CandidateAttachments[];
  @Input()
  addressCity:string;
  @Input()
  addressState:string;
  @Input()
  addressCountry:string;

  workExpYear:number = 0;
  workExpMouth:number = 0;

  constructor(private candidateService:CandidateService,  private redirectController:RedirectController, private roleCheck:RoleCheck){}
@Input()
currentCandidate:CandidateBack;

@Input()
candidateP1Right:boolean;

@Input()
countries:any[]

@Input()
states:any[]

@Input()
lgas:any[]

@Input()
bsConfig: Partial<BsDatepickerConfig>;

@Input()
candidateId:string="";

@Output()
addEvent = new EventEmitter<CandidateBack>();

@Output()
saveEvent = new EventEmitter<CandidateBack>();

@Output()
countryChangeEvent = new EventEmitter();

@Output()
stateChangeEvent = new EventEmitter();

@Output()
changeStatusEvent = new EventEmitter<string>();

add(candidate:CandidateBack)
  {
    
    candidate.workExperience = this.workExpYear + ' year(s) ' + this.workExpMouth + ' month(s)'; 
    console.log(candidate); 
    this.addEvent.emit(candidate);
  }


  save(candidate:CandidateBack)
  {

    candidate.workExperience= `${this.workExpYear} year(s) ${this.workExpMouth} month(s)`.toString();
    console.log(this.workExpYear + ' year(s) ' + this.workExpMouth + ' month(s)');
    console.log(candidate.workExperience);
    console.log(candidate);
    this.saveEvent.emit(candidate);
  }

  handleCountryChange(): void
  {
    this.countryChangeEvent.emit();
  }

  handleStateChange(): void
  {
    this.stateChangeEvent.emit();
  }

  
  chanegStatus(s:string)
  {
    this.changeStatusEvent.emit(s);
  }


onResumeUpload(event:any) {
  const formData = new FormData();
  
  this.file= event.target.files[0];
  console.log(this.file.name);
  if(this.file.name.substring(this.file.name.lastIndexOf('.') + 1).toLowerCase()==='pdf'){
    console.log("pdf");
    this.isPdfResume=true;
  }  
  else{
    this.isPdfResume=false;
  }
  this.attachments= this.attachments=this.currentCandidate.attachments || [];
  this.attachments.push(new CandidateAttachments(this.currentCandidate.candidateId,true,this.currentCandidate.candidateId+"_Resume.pdf"));
   this.currentCandidate.attachments=this.attachments;
   console.log(this.currentCandidate);
  formData.append('files', this.file, this.file.name);
  this.candidateService.upload(formData,this.currentCandidate.candidateId).subscribe(data=>{
    console.log(data);
  })
  }

  onFileUpload(event:any) {
    const formData = new FormData();
    
    this.file= event.target.files[0];
    console.log(this.file.name);
    if(this.file.name.substring(this.file.name.lastIndexOf('.') + 1).toLowerCase()==='pdf'){
      console.log("File pdf");
      this.isPdfFile=true;
    }  
    else{
      this.isPdfFile=false;
    }
    this.attachments=this.currentCandidate.attachments || [];
    this.attachments.push(new CandidateAttachments(this.currentCandidate.candidateId,true,this.currentCandidate.candidateId+"_File.pdf"));
     this.currentCandidate.attachments=this.attachments;
     console.log(this.currentCandidate);
    formData.append('files', this.file, this.file.name);
    this.candidateService.uploadFile(formData,this.currentCandidate.candidateId).subscribe(data=>{
      console.log(data);
    })
    }

  download(filename:string) {
    this.candidateService.download(filename).subscribe(
      event => {
        if(event.type==HttpEventType.Response)
        {
          saveAs(new File([event.body!], event.headers.get('File-Name')!, 
                {type: `${event.headers.get('Content-Type')};charset=utf-8`}));
        }
      });

    }

}
