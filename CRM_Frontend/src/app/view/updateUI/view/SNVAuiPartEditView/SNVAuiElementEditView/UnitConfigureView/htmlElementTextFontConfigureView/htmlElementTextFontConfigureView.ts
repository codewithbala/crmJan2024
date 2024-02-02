import {Component, Input, OnInit} from '@angular/core';
import {SNVAHtmlColor} from "../../../../../model/unit/SNVAHtmlColor";
import {SNVAHtmlTextFont} from "../../../../../model/unit/SNVAHtmlTextFont";
import {HtmlParameter} from "../../../../../../../config/htmlParameter";
import {SNVAHtmlTextPosition} from "../../../../../model/unit/SNVAHtmlTextPosition";

@Component({
  selector: 'app-html-element-text-configure-view',
  templateUrl: './htmlElementTextFontConfigureView.html',
  styleUrls: ['./htmlElementTextFontConfigureView.css']
})
export class HtmlElementTextFontConfigureView implements OnInit
{
  @Input() title:string;
  @Input() color:SNVAHtmlColor;
  @Input() font:SNVAHtmlTextFont;
  @Input() position:SNVAHtmlTextPosition;

  inputColor:string = '#FFFFFF';
  inputAplha:number = 100;

  constructor(public htmlParameter:HtmlParameter)
  {}

  ngOnInit(): void
  {
    this.inputColor = this.color.getColorValue();
    this.inputAplha = this.color.aChannel * 100;
  }

  change()
  {
    this.color.setColorValue(this.inputColor);
    this.color.setTransparency(this.inputAplha);
  }

}
