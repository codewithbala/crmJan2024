import {Component, Input} from '@angular/core';
import {SNVAHtmlBoxShadow} from "../../../../model/unit/SNVAHtmlBoxShadow";
import {HtmlParameter} from "../../../../../../config/htmlParameter";
import {SNVAHtmlTextShadow} from "../../../../model/unit/SNVAHtmlTextShadow";

@Component({
  selector: 'app-html-element-text-shadow-configure-view',
  templateUrl: './htmlElementTextShadowConfigureView.html',
  styleUrls: ['./htmlElementTextShadowConfigureView.css']
})
export class HtmlElementTextShadowConfigureView
{
  @Input() shadowList:SNVAHtmlTextShadow[];

  inputColor:string = '#FFFFFF';
  inputAplha:number = 100;
  currentShadow:string = ''
  currentCopy:SNVAHtmlTextShadow = new SNVAHtmlTextShadow('');

  constructor(public htmlParameter:HtmlParameter)
  {}

  ngOnInit(): void
  {}

  change()
  {
    this.currentCopy.color.setColorValue(this.inputColor);
    this.currentCopy.color.setTransparency(this.inputAplha);
  }

  view(shadow:SNVAHtmlTextShadow)
  {
    this.currentShadow = shadow.toString();
    this.currentCopy = new SNVAHtmlTextShadow(shadow.toString());
    this.inputColor = this.currentCopy.color.getColorValue();
    this.inputAplha = this.currentCopy.color.aChannel * 100;
  }

  add()
  {
    this.shadowList.unshift(new SNVAHtmlTextShadow('0px 0px 0px #000000'));
  }
  delete(shadow:SNVAHtmlTextShadow)
  {
    for(let i = 0; i< this.shadowList.length; i++)
    {
      if(this.shadowList[i].toString() == shadow.toString())
      {
        this.shadowList.splice(i, 1);
      }
    }
  }

  save()
  {
    for(let i = 0; i< this.shadowList.length; i++)
    {
      if(this.shadowList[i].toString() == this.currentShadow)
      {
        this.shadowList[i] = new SNVAHtmlTextShadow(this.currentCopy.toString());
        this.currentShadow = this.shadowList[i].toString();
      }
    }
  }
}
