import {Component, EventEmitter, Input, OnInit, Output, DoCheck} from '@angular/core';
import {SNVAHtmlElementStyle} from "../../../model/SNVAHtmlElementStyle";
import {UiService} from "../../../service/uiService";
import {UiModel} from "../../../model/uiModel";
import {SNVAHtmlTextShadow} from "../../../model/unit/SNVAHtmlTextShadow";

@Component({
  selector: 'SNVAuiElementEditView',
  templateUrl: './SNVAuiElementEditView.html',
  styleUrls: ['./SNVAuiElementEditView.css']
})
export class SNVAuiElementEditView implements OnInit, DoCheck
{
  @Input() uiModel:UiModel;
  @Output() uiModelChange = new EventEmitter<UiModel>();

  elementStyle:string = '';
  elementClass:string = '';

  /*
  @Input() part:string;
  @Output() outputId      = new EventEmitter<number>();*/

  state:string = 'background';
  class1:string = 'col-4 border border-bottom-0 rounded-top-3 border-secondary'
  class2:string = 'col-4 border-bottom border-secondary'
  class3:string = 'col-4 border-bottom border-secondary'

  public snvaHtmlElementStyle:SNVAHtmlElementStyle = new SNVAHtmlElementStyle('');

  constructor(private uiService:UiService)
  {}

  ngOnInit(): void
  {
    this.elementClass = this.uiModel.class;
    this.elementStyle = this.uiModel.style;
    this.snvaHtmlElementStyle = new SNVAHtmlElementStyle(this.elementStyle);
  }

  ngDoCheck(): void
  {
    if(this.uiModel.style != this.elementStyle || this.uiModel.class != this.elementClass)
    {
      this.elementClass = this.uiModel.class;
      this.elementStyle = this.uiModel.style;
      this.snvaHtmlElementStyle = new SNVAHtmlElementStyle(this.elementStyle);
    }
  }

  changeState(s:string)
  {
    this.state = s;
    if(s == 'background')
    {
      this.class1 = 'col-4 border border-bottom-0 rounded-top border-secondary';
      this.class2 = 'col-4 border-bottom border-secondary';
      this.class3 = 'col-4 border-bottom border-secondary';
    }
    if(s == 'border')
    {
      this.class1 = 'col-4 border-bottom border-secondary';
      this.class2 = 'col-4 border border-bottom-0 rounded-top border-secondary';
      this.class3 = 'col-4 border-bottom border-secondary';
    }
    if(s == 'text-font')
    {
      this.class1 = 'col-4 border-bottom border-secondary';
      this.class2 = 'col-4 border-bottom border-secondary';
      this.class3 = 'col-4 border border-bottom-0 rounded-top border-secondary';
    }
  }

  updateTextShadow(shadowList:SNVAHtmlTextShadow[])
  {
    console.log("SNVAuiElementEditView -> " + shadowList);
    this.snvaHtmlElementStyle.textShadow = shadowList;
    this.elementStyle = this.snvaHtmlElementStyle.toString();
  }

  changeUiModel()
  {
    console.log("#########SNVAuiElementEditView -> " + this.snvaHtmlElementStyle.textShadow);
    console.log("SNVAuiElementEditView#########");
    this.uiModel.style = this.snvaHtmlElementStyle.toString();
    //this.elementStyle = this.uiModel.style;
    //this.elementClass = this.uiModel.class;
    this.uiModelChange.emit(this.uiModel);
  }
}
