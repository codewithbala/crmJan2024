import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {UiService} from "../../service/uiService";
import {UiModel} from "../../model/uiModel";
import {SNVAHtmlBoxShadow} from "../../model/unit/SNVAHtmlBoxShadow";

@Component({
  selector: 'text',
  templateUrl: './text.html',
  styleUrls: ['./text.css']
})
export class Text
{
  @Input() shadowList:SNVAHtmlBoxShadow[];

  add()
  {
    this.shadowList.unshift(new SNVAHtmlBoxShadow('0px 0px 0px rgba(0,0,0,0)'));
  }
  delete()
  {
    this.shadowList.splice(this.shadowList.length-1, 1);
  }
}
