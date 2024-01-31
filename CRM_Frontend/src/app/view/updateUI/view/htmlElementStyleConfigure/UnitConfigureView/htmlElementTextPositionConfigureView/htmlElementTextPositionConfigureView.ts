import {Component, Input} from '@angular/core';
import {SNVAHtmlTextPosition} from "../../../../model/unit/SNVAHtmlTextPosition";
import {HtmlParameter} from "../../../../../../config/htmlParameter";

@Component({
  selector: 'app-html-element-text-position-configure-view',
  templateUrl: './htmlElementTextPositionConfigureView.html',
  styleUrls: ['./htmlElementTextPositionConfigureView.css']
})
export class HtmlElementTextPositionConfigureView
{
  @Input() position:SNVAHtmlTextPosition;
  constructor(public htmlParameter:HtmlParameter)
  {}
}
