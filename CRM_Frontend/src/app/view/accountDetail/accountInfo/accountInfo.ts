import {Component, Input} from '@angular/core';

@Component({
  selector: 'app-account-info',
  templateUrl: './accountInfo.html',
  styleUrls: ['./accountInfo.css']
})
export class AccountInfo
{
  @Input() currentUser:any;
  imageUrl: string | ArrayBuffer | null = "https://media.istockphoto.com/id/522855255/vector/male-profile-flat-blue-simple-icon-with-long-shadow.jpg?s=612x612&w=0&k=20&c=EQa9pV1fZEGfGCW_aEK5X_Gyob8YuRcOYCYZeuBzztM=";

  onFileSelected(event: any): void {
    const file = event.target.files[0];
    if (file) {
      this.readImage(file);
    }
  }

  readImage(file: File): void {
    const reader = new FileReader();
    reader.onload = (e) => {
      // Ensure that e.target.result is not undefined before assignment
      if (e.target?.result) {
        this.imageUrl = e.target.result;
      }
    };
    reader.readAsDataURL(file);
  }
}
