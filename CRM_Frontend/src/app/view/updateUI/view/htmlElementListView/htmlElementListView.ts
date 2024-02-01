import {Component, Input, OnInit} from '@angular/core';
import {UiService} from "../../service/uiService";
import {UiModel} from "../../model/uiModel";

@Component({
  selector: 'app-html-element-list-view',
  templateUrl: './htmlElementListView.html',
  styleUrls: ['./htmlElementListView.css']
})
export class HtmlElementListView implements OnInit
{
  @Input() part:string;
  public modelList:UiModel[] = [];

  constructor(private uiService:UiService) {
  }

  ngOnInit(): void
  {
    this.uiService.getUiConfigureByPart(this.part).subscribe(
        data =>
        {
          data.forEach(
              e =>
              {
                if(e.model != 'read only')
                {
                  this.modelList.push(e);
                }
              }
          )
        }
    )
  }
}
