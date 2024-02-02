import {Component, Input} from '@angular/core';
import {HtmlParameter} from "../../../../../../../config/htmlParameter";
import {SNVAHtmlBoxShadow} from "../../../../../model/unit/SNVAHtmlBoxShadow";

@Component({
  selector: 'app-html-element-box-shadow-configure-view',
  templateUrl: './htmlElementBoxShadowConfigureView.html',
  styleUrls: ['./htmlElementBoxShadowConfigureView.css']
})
export class HtmlElementBoxShadowConfigureView
{
  @Input() shadowList:SNVAHtmlBoxShadow[];

  inputColor:string = '#FFFFFF';
  inputAplha:number = 100;
  insetValue:boolean = false;
  currentShadow:string = ''
  currentCopy:SNVAHtmlBoxShadow = new SNVAHtmlBoxShadow('');

  constructor(public htmlParameter:HtmlParameter)
  {}

  ngOnInit(): void
  {}

  change()
  {
    this.currentCopy.color.setColorValue(this.inputColor);
    this.currentCopy.color.setTransparency(this.inputAplha);
  }

  view(shadow:SNVAHtmlBoxShadow)
  {
    this.currentShadow = shadow.toString();
    //this.currentCopy = new SNVAHtmlBoxShadow(shadow.toString());
    this.currentCopy = shadow;
    this.inputColor = this.currentCopy.color.getColorValue();
    this.inputAplha = this.currentCopy.color.aChannel * 100;
    this.insetValue = this.currentCopy.inset;
  }

  add()
  {
    this.shadowList.unshift(new SNVAHtmlBoxShadow('0px 0px 0px 0px #000000'));
  }
  delete()
  {
    for(let i = 0; i< this.shadowList.length; i++)
    {
      if(this.shadowList[i].toString() == this.currentCopy.toString())
      {
        this.shadowList.splice(i, 1);
        this.currentShadow = ''
      }
    }
  }

  inset()
  {
    if(this.insetValue)
    {
      this.currentCopy.inset = true;
    }
    else
    {
      this.currentCopy.inset = false;
    }
  }

  save()
  {
    for(let i = 0; i< this.shadowList.length; i++)
    {
      if(this.shadowList[i].toString() == this.currentShadow)
      {
        this.shadowList[i] = new SNVAHtmlBoxShadow(this.currentCopy.toString());
        this.currentShadow = this.shadowList[i].toString();
      }
    }
  }
}
