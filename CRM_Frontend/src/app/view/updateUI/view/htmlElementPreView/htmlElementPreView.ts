import {Component, Input, OnInit} from '@angular/core';
import {SNVAHtmlElementStyle} from "../../model/SNVAHtmlElementStyle";
import {UiService} from "../../service/uiService";
import {UiModel} from "../../model/uiModel";

@Component({
  selector: 'app-html-element-pre-view',
  templateUrl: './htmlElementPreView.html',
  styleUrls: ['./htmlElementPreView.css']
})
export class HtmlElementPreView implements OnInit
{
  @Input() part:string;
  @Input() uiModel:UiModel[];

  constructor(private uiService:UiService)
  {}

  ngOnInit(): void
  {

  }

}
