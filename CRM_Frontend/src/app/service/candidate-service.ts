import {Injectable} from "@angular/core";
import {HttpClient, HttpHeaders, HttpParams} from "@angular/common/http";
import {observable, Observable} from "rxjs";
import { Candidate } from "../model/candidate";
import { CandidateDetail } from "../model/candidate-detail";
import { CandidateBack } from "../model/candidate-back";
import { NextCand } from "../model/next-cand";

@Injectable({
  providedIn: 'root'
})
export class CandidateService
{
  private baseURL = "http://localhost:8080/Candidates"; // TODO
  constructor(private http:HttpClient)
  { }

  getAllCandidates(){
    return this.http.get<Candidate[]>(this.baseURL+"/all")
    }
  getCandidate(id:string){
      return this.http.get<CandidateBack>(`${this.baseURL}/${id}`)
  }
  saveCandidate(candidate:CandidateBack){
    console.log(candidate);
    return this.http.post<CandidateBack>(`${this.baseURL}/add`,candidate)
  }
  setNextCandidateId(){
    return this.http.get<NextCand>(`${this.baseURL}/next`)
  }

  updateCandidate(candidate:CandidateBack)
  {
    // @ts-ignore
    return this.http.put<string>(`${this.baseURL}/update`, candidate, {responseType: 'text'})
  }

}
