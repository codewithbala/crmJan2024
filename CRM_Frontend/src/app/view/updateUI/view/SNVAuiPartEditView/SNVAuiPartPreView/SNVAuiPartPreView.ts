import {Component, Input, OnInit} from '@angular/core';
import {SNVAHtmlElementStyle} from "../../../model/SNVAHtmlElementStyle";
import {UiService} from "../../../service/uiService";
import {UiModel} from "../../../model/uiModel";

@Component({
  selector: 'SNVAuiPartPreView',
  templateUrl: './SNVAuiPartPreView.html',
  styleUrls: ['./SNVAuiPartPreView.css']
})
export class SNVAuiPartPreView implements OnInit
{
  @Input() part:string;
  @Input() uiModelList:UiModel[];

  constructor(private uiService:UiService)
  {}

  ngOnInit(): void
  {
    console.log('### htmlElementPreView');
    console.log(this.uiModelList);
    console.log("#############")
  }

  showCurrentElement()
  {
    console.log(this.uiModelList);
  }
}
