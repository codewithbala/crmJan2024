import {Component, Input} from '@angular/core';
import {DeleteUserConfirmView} from "../../popView/deleteUserConfirmView/deleteUserConfirmView";
import {UIconfigure} from "../../../config/UIconfigure";

@Component({
  selector: 'app-account-info-read-only',
  templateUrl: './accountInfoReadOnly.html',
  styleUrls: ['./accountInfoReadOnly.css']
})
export class AccountInfoReadOnly
{
  @Input() currentUser:any;
  imageUrl: string | ArrayBuffer | null = "https://media.istockphoto.com/id/522855255/vector/male-profile-flat-blue-simple-icon-with-long-shadow.jpg?s=612x612&w=0&k=20&c=EQa9pV1fZEGfGCW_aEK5X_Gyob8YuRcOYCYZeuBzztM=";

  constructor(public uiconfigure:UIconfigure)
  {
  }
}
