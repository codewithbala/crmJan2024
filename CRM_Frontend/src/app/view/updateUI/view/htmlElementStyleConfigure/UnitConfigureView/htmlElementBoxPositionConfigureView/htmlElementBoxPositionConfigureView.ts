import {Component, Input} from '@angular/core';
import {SNVAHtmlBoxPosition} from "../../../../model/unit/SNVAHtmlBoxPosition";
import {HtmlParameter} from "../../../../../../config/htmlParameter";

@Component({
  selector: 'app-html-element-box-position-configure-view',
  templateUrl: './htmlElementBoxPositionConfigureView.html',
  styleUrls: ['./htmlElementBoxPositionConfigureView.css']
})
export class HtmlElementBoxPositionConfigureView
{
  @Input() position: SNVAHtmlBoxPosition;

  constructor(public htmlParameter:HtmlParameter)
  {}
}
