import {Component, EventEmitter, Input, Output} from '@angular/core';
import {UIconfigure} from "../../../config/UIconfigure";

@Component({
  selector: 'app-menu-bar',
  templateUrl: './menuBar.html',
  styleUrls: ['./menuBar.css']
})
export class MenuBar
{
  @Input() firstName:any;
  @Input() lastName:any;
  @Output() currentStatus = new EventEmitter<string>();

  constructor(public uiconfigure:UIconfigure)
  {
  }
  changeStatus( status:string )
  {
    this.currentStatus.emit(status);
  }

}
