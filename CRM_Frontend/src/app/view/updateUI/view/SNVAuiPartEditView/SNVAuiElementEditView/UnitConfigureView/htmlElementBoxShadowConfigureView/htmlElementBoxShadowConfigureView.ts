import {Component, EventEmitter, Input, Output} from '@angular/core';
import {HtmlParameter} from "../../../../../../../config/htmlParameter";
import {SNVAHtmlBoxShadow} from "../../../../../model/unit/SNVAHtmlBoxShadow";
import {UiModel} from "../../../../../model/uiModel";

@Component({
  selector: 'app-html-element-box-shadow-configure-view',
  templateUrl: './htmlElementBoxShadowConfigureView.html',
  styleUrls: ['./htmlElementBoxShadowConfigureView.css']
})
export class HtmlElementBoxShadowConfigureView
{
  @Input() shadowList:SNVAHtmlBoxShadow[];
  @Output() shadowChange:EventEmitter<SNVAHtmlBoxShadow[]> =  new EventEmitter<SNVAHtmlBoxShadow[]>();


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
    this.currentCopy = new SNVAHtmlBoxShadow(shadow.toString());
    this.inputColor = this.currentCopy.color.getColorValue();
    this.inputAplha = this.currentCopy.color.aChannel * 100;
    this.insetValue = this.currentCopy.inset;
  }

  add()
  {
    this.shadowList.unshift(new SNVAHtmlBoxShadow('0px 0px 0px 0px #000000'));
    this.shadowChange.emit(this.shadowList);
  }

  delete(shadow:SNVAHtmlBoxShadow)
  {
    for(let i = 0; i< this.shadowList.length; i++)
    {
      if(this.shadowList[i].toString() == shadow.toString())
      {
        this.shadowList.splice(i, 1);
        this.currentShadow = ''
        this.shadowChange.emit(this.shadowList);
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
        this.currentShadow = '';
        this.shadowChange.emit(this.shadowList);
      }
    }
  }
}
