import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {UiService} from "../../service/uiService";
import {UiModel} from "../../model/uiModel";

@Component({
  selector: 'text',
  templateUrl: './text.html',
  styleUrls: ['./text.css']
})
export class Text
{
  @Input() uiModelList:UiModel[] = [];
}
