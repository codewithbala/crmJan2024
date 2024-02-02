import {Component, Input, OnInit} from '@angular/core';
import {UiModel} from "../../model/uiModel";
import {UiService} from "../../service/uiService";

@Component({
  selector: 'SNVAuiPartEditView',
  templateUrl: './SNVAuiPartEditView.html',
  styleUrls: ['./SNVAuiPartEditView.css']
})
export class SNVAuiPartEditView implements OnInit
{
  @Input() part:string;
  uiModelList:UiModel[] = [];
  currentElement:UiModel = new UiModel();

  constructor(private uiService:UiService)
  { }
  ngOnInit(): void
  {
    this.getElementList(this.part);
  }

  getElementList(s:string)
  {
    this.uiService.getUiConfigureByPart(s).subscribe(
        async data =>
        {
          this.uiModelList = data
        } )
  }

  setCurrentElement(u:UiModel)
  {
    this.currentElement = u;
  }
}
