import {Component, EventEmitter, Input, Output} from '@angular/core';
import {SNVAHtmlBoxShadow} from "../../../../../model/unit/SNVAHtmlBoxShadow";
import {HtmlParameter} from "../../../../../../../config/htmlParameter";
import {SNVAHtmlTextShadow} from "../../../../../model/unit/SNVAHtmlTextShadow";
import {UiModel} from "../../../../../model/uiModel";

@Component({
  selector: 'app-html-element-text-shadow-configure-view',
  templateUrl: './htmlElementTextShadowConfigureView.html',
  styleUrls: ['./htmlElementTextShadowConfigureView.css']
})
export class HtmlElementTextShadowConfigureView
{
  @Input() shadowList:SNVAHtmlTextShadow[];
  //@Output() shadowListChange:EventEmitter<SNVAHtmlTextShadow[]> = new EventEmitter<SNVAHtmlTextShadow[]>();

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
    this.shadowList.forEach(
        s=>
        {
          if(this.currentCopy.toString() == s.toString())
          {
            this.currentCopy = s;
          }
        }
    )
  }

  view(shadow:SNVAHtmlTextShadow)
  {
    this.currentShadow = shadow.toString();
    this.currentCopy = shadow;
    this.inputColor = this.currentCopy.color.getColorValue();
    this.inputAplha = this.currentCopy.color.aChannel * 100;
  }

  add()
  {
    this.shadowList.unshift(new SNVAHtmlTextShadow('0px 0px 0px #000000'));
  }
  delete()
  {
    for(let i = 0; i< this.shadowList.length; i++)
    {
      if(this.shadowList[i].toString() == this.currentCopy.toString())
      {
        this.shadowList.splice(i, 1);
        this.currentShadow = '';
        this.currentCopy = new SNVAHtmlTextShadow('');
      }
    }
  }
}
