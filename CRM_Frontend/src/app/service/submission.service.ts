import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Submission } from '../model/submission';

@Injectable({
  providedIn: 'root'
})
export class SubmissionService {

  private baseURL = "http://localhost:8080/api/v1/submissions"; // TODO
  constructor(private http:HttpClient)
  { }
  getAllSubmissions(){
    return this.http.get<Submission[]>(this.baseURL)
    }
  getSubmission(id:string){
      return this.http.get<Submission>(`${this.baseURL}/${id}`)
  }
  saveSubmission(submission:Submission){
    console.log(submission);
    return this.http.post<Submission>(`${this.baseURL}`,submission)
  }
  putSubmission(submission:Submission){
    console.log(submission);
    return this.http.put<Submission>(`${this.baseURL}/${submission.id}`,submission)
  }

}
