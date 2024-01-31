import {Component, Input} from '@angular/core';
import {HtmlParameter} from "../../../../../../config/htmlParameter";
import {SNVAHtmlBoxRadius} from "../../../../model/unit/SNVAHtmlBoxRadius";
import {SNVAHtmlBoxSize} from "../../../../model/unit/SNVAHtmlBoxSize";
import {SNVAHtmlBoxBorder} from "../../../../model/unit/SNVAHtmlBoxBorder";

@Component({
  selector: 'app-html-element-box-border-configure-view',
  templateUrl: './htmlElementBoxBorderConfigureView.html',
  styleUrls: ['./htmlElementBoxBorderConfigureView.css']
})
export class HtmlElementBoxBorderConfigureView
{
  @Input() radius  : SNVAHtmlBoxRadius;
  @Input() boxSize : SNVAHtmlBoxSize;
  @Input() border  : SNVAHtmlBoxBorder;

  topColor:string;
  topAlpha:number;
  rightColor:string;
  rightAlpha:number;
  bottomColor:string;
  bottomAlpha:number;
  leftColor:string;
  leftAlpha:number;


  constructor(public htmlParameter:HtmlParameter)
  {}

  ngOnInit(): void
  {
    this.topColor    = this.border.borderColor.topColor.getColorValue();
    this.topAlpha    = this.border.borderColor.topColor.aChannel * 100;
    this.rightColor  = this.border.borderColor.rightColor.getColorValue();
    this.rightAlpha  = this.border.borderColor.rightColor.aChannel * 100;
    this.bottomColor = this.border.borderColor.bottomColor.getColorValue();
    this.bottomAlpha = this.border.borderColor.bottomColor.aChannel * 100;
    this.leftColor   = this.border.borderColor.leftColor.getColorValue();
    this.leftAlpha   = this.border.borderColor.leftColor.aChannel * 100;
  }

  changeTopColor()
  {
    this.border.borderColor.topColor.setColorValue(this.topColor);
    this.border.borderColor.topColor.setTransparency(this.topAlpha);
  }

  changeRightColor()
  {
    this.border.borderColor.rightColor.setColorValue(this.rightColor);
    this.border.borderColor.rightColor.setTransparency(this.rightAlpha);
  }

  changeBottomColor()
  {
    this.border.borderColor.bottomColor.setColorValue(this.bottomColor);
    this.border.borderColor.bottomColor.setTransparency(this.bottomAlpha);
  }

  changeLeftColor()
  {
    this.border.borderColor.leftColor.setColorValue(this.leftColor);
    this.border.borderColor.leftColor.setTransparency(this.leftAlpha);
  }


}
