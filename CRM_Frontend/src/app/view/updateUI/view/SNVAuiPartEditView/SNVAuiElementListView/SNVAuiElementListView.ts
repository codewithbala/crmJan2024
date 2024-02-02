import {Component, EventEmitter, Input, Output} from '@angular/core';
import {UiModel} from "../../../model/uiModel";
import {UiService} from "../../../service/uiService";

@Component({
  selector: 'SNVAuiElementListView',
  templateUrl: './SNVAuiElementListView.html',
  styleUrls: ['./SNVAuiElementListView.css']
})
export class SNVAuiElementListView
{
  @Input() part:string = '';
  @Input() uiModelList:UiModel[] = [];
  @Output() currentElement:EventEmitter<UiModel> = new EventEmitter<UiModel>();
  currentId:number = -1;
  childUI:UiModel = new UiModel();

  constructor(private uiService:UiService) {
  }

  chooseElement(u:UiModel)
  {
    this.currentId = u.id;
    this.childUI = u;
    this.currentElement.emit(u);
  }
}
