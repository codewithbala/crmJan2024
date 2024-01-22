import { Component, Input } from '@angular/core';
import { MenuData } from 'src/app/data/menuData';
import { CandidateBack } from 'src/app/model/candidate-back';

@Component({
  selector: 'candidate-tech-view',
  templateUrl: './candidate-tech-view.component.html',
  styleUrls: ['./candidate-tech-view.component.css']
})
export class CandidateTechViewComponent {
  menuData:MenuData = new MenuData();
  @Input()
  currentCandidate:CandidateBack;
  @Input()
candidateP2Right=true;
}
