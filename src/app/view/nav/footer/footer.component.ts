import { Component } from '@angular/core';
import {UIconfigure} from "../../../config/UIconfigure";

@Component({
  selector: 'app-footer',
  templateUrl: './footer.component.html',
  styleUrls: ['./footer.component.css']
})
export class FooterComponent
{
  constructor(public uiconfigure:UIconfigure)
  {
  }
}
