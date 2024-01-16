import {Injectable} from "@angular/core";
import {BsModalRef, BsModalService} from "ngx-bootstrap/modal";
import {ResponeMessage} from "../view/popView/responeMessage/responeMessage";

@Injectable({
  providedIn: 'root'
})
export class RedirectController
{
  bsModalRef: BsModalRef;
  constructor( private modalService: BsModalService )
  {}
  redirect(message:string, error:string, url:string)
  {
    this.bsModalRef = this.modalService.show(ResponeMessage, {class: 'modal-lg popBox'});
    this.bsModalRef.content.message = message;
    this.bsModalRef.content.error = error;
    setTimeout(
      function ()
      {
        if(url == '')
        {
          location.reload();
        }
        else
        {
          window.location.href = url;
        }
      }, 3000);
  }
}
