import {Component, EventEmitter, Output} from '@angular/core';

@Component({
  selector: 'SNVAuiPartListView',
  templateUrl: './SNVAuiPartListView.html',
  styleUrls: ['./SNVAuiPartListView.css']
})
export class SNVAuiPartListView
{
  @Output() part = new EventEmitter<string>();

  changePart(s:string)
  {
    this.part.emit(s);
  }

}
