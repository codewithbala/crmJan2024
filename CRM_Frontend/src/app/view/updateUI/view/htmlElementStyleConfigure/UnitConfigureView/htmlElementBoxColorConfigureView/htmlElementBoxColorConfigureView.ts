import {Component, Input} from '@angular/core';
import {HtmlParameter} from "../../../../../../config/htmlParameter";
import {SNVAHtmlColor} from "../../../../model/unit/SNVAHtmlColor";

@Component({
  selector: 'app-html-element-box-back-ground-configure-view',
  templateUrl: './htmlElementBoxColorConfigureView.html',
  styleUrls: ['./htmlElementBoxColorConfigureView.css']
})
export class HtmlElementBoxColorConfigureView
{
  @Input() boxColor:SNVAHtmlColor

  constructor(public htmlParameter:HtmlParameter)
  {}
}
