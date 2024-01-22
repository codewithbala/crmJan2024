import { Component, Input } from '@angular/core';
import { BsDatepickerConfig } from 'ngx-bootstrap/datepicker';
import { MenuData } from 'src/app/data/menuData';
import { CandidateBack } from 'src/app/model/candidate-back';

@Component({
  selector: 'candidate-bdview',
  templateUrl: './candidate-bdview.component.html',
  styleUrls: ['./candidate-bdview.component.css']
})
export class CandidateBDViewComponent {
  menuData:MenuData = new MenuData();
  @Input()
  loiSent:string;   
  @Input()
  loiAccepted:string;
  @Input()
  joinedBatch:string;
  @Input()
  currentCandidate:CandidateBack;
  @Input()
  candidateP3Right:boolean;
  @Input()
 bsConfig: Partial<BsDatepickerConfig>;
}
