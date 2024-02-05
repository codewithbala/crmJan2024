import {Component, Input} from '@angular/core';
import {UiService} from "../../../service/uiService";
import {UiModel} from "../../../model/uiModel";
import {delay} from "rxjs";

@Component({
  selector: 'SNVAuiPartPreView',
  templateUrl: './SNVAuiPartPreView.html',
  styleUrls: ['./SNVAuiPartPreView.css']
})
export class SNVAuiPartPreView
{
  @Input() part:string;
  @Input() uiModelList:UiModel[];

  constructor(private uiService:UiService)
  {}

  showCurrentElement()
  {
    for (let i = 0; i < this.uiModelList.length; i++)
    {
      this.uiService.updateConfigure(this.part, this.uiModelList[i]).subscribe(
          data =>
          {
            console.log("[Save UI]" + data);
          }
      )
    }
  }

}
