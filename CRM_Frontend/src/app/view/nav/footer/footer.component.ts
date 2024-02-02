import {Component, Input, OnInit} from '@angular/core';
import {UIconfigure} from "../../../config/UIconfigure";
import {UiModel} from "../../updateUI/model/uiModel";

@Component({
  selector: 'app-footer',
  templateUrl: './footer.component.html',
  styleUrls: ['./footer.component.css']
})
export class FooterComponent
{
  @Input() model:string;
  @Input() ui:UiModel[];

  constructor(public uiconfigure:UIconfigure)
  {
    this.ui = this.uiconfigure.footer;
  }
}
