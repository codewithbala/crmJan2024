import {Component, Input} from '@angular/core';
import {UIconfigure} from "../../../config/UIconfigure";

@Component({
  selector: 'app-menu-bar-read-only',
  templateUrl: './menuBarReadOnly.html',
  styleUrls: ['./menuBarReadOnly.css']
})
export class MenuBarReadOnly
{
  @Input() firstName:any;
  @Input() lastName:any;
  constructor(public uiconfigure:UIconfigure)
  {
  }
}
