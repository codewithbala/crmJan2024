import {Component, Input} from '@angular/core';
import {UIconfigure} from "../../../config/UIconfigure";

@Component({
  selector: 'app-error-page',
  templateUrl: './errorPage.html',
  styleUrls: ['./errorPage.css']
})
export class ErrorPage
{
  @Input() erroeMessage:any;

  constructor(public uiconfigure:UIconfigure)
  {
  }
}
