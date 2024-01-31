import {HttpClient, HttpHeaders} from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import {UiModel} from "../model/uiModel";

@Injectable({
    providedIn: 'root'
})
export class UiService
{
    headers = new HttpHeaders().set('Content-type','application/json').set('Accept', 'application/json')
    httpOptions = {
        headers:this.headers
    }
    constructor(private httpClient: HttpClient,) { }

    getUiConfigureByPart(part:string):Observable<UiModel[]>
    {
        return this.httpClient.get<UiModel[]>('http://localhost:3000/'+ part)
    }
    getUiConfigureById(part:string, id:number):Observable<UiModel>
    {
        return this.httpClient.get<UiModel>('http://localhost:3000/'+ part+'/'+ id)
    }

    updateConfigure(part:string, uiModel:UiModel):Observable<UiModel>
    {
        return this.httpClient.put<UiModel>('http://localhost:3000/'+ part +'/'+ uiModel.id,  uiModel, this.httpOptions);
    }

}
