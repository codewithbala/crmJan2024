import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {SNVAHtmlElementStyle} from "../../model/SNVAHtmlElementStyle";
import {UiService} from "../../service/uiService";
import {UiModel} from "../../model/uiModel";

@Component({
  selector: 'app-html-element-configure',
  templateUrl: './htmlElementStyleConfigureView.html',
  styleUrls: ['./htmlElementStyleConfigureView.css']
})
export class HtmlElementStyleConfigureView implements OnInit
{
  parentUI:UiModel = new UiModel();
  @Input() uiModel:UiModel;
  @Input() part:string;

  state:string = 'background';
  class1:string = 'col-4 border border-bottom-0 rounded-top-3 border-secondary'
  class2:string = 'col-4 border-bottom border-secondary'
  class3:string = 'col-4 border-bottom border-secondary'

  public elementStyle:SNVAHtmlElementStyle = new SNVAHtmlElementStyle('');

  constructor(private uiService:UiService)
  {}
  ngOnInit(): void
  {
    this.elementStyle = new SNVAHtmlElementStyle(this.uiModel.style);
    this.uiService.getUiConfigureById(this.part, this.uiModel.parentId).subscribe(
        data=>
        {
          this.parentUI = data;
        }
    )
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

  changeUiModel()
  {
    this.uiModel.style = this.elementStyle.toString();
  }
}
