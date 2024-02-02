import {Component, OnInit} from '@angular/core';
import {UIconfigure} from "../../../config/UIconfigure";
import {UiService} from "../service/uiService";
import {UiModel} from "../model/uiModel";
import {compose} from "@ngrx/store";

@Component({
  selector: 'app-test',
  templateUrl: './updateUI.html',
  styleUrls: ['./updateUI.css']
})
export class UpdateUI implements OnInit
{
  part:string = '' // html part

  uiModelList:UiModel[] = [];
  currenUiModel  : UiModel = new UiModel();

  constructor(private uiService:UiService, public uiconfigure:UIconfigure)
  {}

  ngOnInit(): void
  {

  }

  changeParts(s:string)
  {
    this.part = s;
  }

  getElementUI(id:number)
  {
    this.uiModelList.forEach(u =>
    {
      if(u.id == id)
      {
        this.currenUiModel = u;
      }
    })
  }

  showchild()
  {
    console.log(this.currenUiModel);
  }


}
