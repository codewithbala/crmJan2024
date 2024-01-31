import {Component, OnInit} from '@angular/core';
import {UIconfigure} from "../../../config/UIconfigure";
import {UiService} from "../service/uiService";
import {UiModel} from "../model/uiModel";

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
    this.currenUiModel.id=2;
    this.currenUiModel.path  = 'header/title'
    this.currenUiModel.class = ''
    this.currenUiModel.style = 'color:rgba(241,159,5,1);font-size:3em;'
    this.currenUiModel.name = "Logo"
    this.currenUiModel.model = "style only"
    this.currenUiModel.parentId = 1
  }

  changePart(s:string)
  {
    this.part = s;

    this.uiService.getUiConfigureByPart(this.part).subscribe(
        data =>
        {
          this.uiModelList = data;
          console.log(data);
        }
    )

  }

  showchild()
  {
    console.log(this.currenUiModel);
  }


}
