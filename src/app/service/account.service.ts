import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { User } from '../model/user';
import {CandidateBack} from "../model/candidate-back";
import {RoleCheck} from "../tools/role-check";

@Injectable({
  providedIn: 'root'
})
export class AccountService
{
  constructor(private httpClient: HttpClient,private router:Router, private roleCheck:RoleCheck) { }

  getUserById(userId:number):Observable<User>
  {
    console.log(userId)
    return this.httpClient.get<User>('http://localhost:8080/api/v1/users/'+ userId)
  }

  getAllUser():Observable<User[]>{
    return this.httpClient.get<User[]>('http://localhost:8080/getAllUsers')
  }

  updateUser(user:User):Observable<User>
  {
    console.log(user)
    delete user['authorities'];
    return this.httpClient.put<User>('http://localhost:8080/api/v1/users/personal-details/'+ user.id,user.userPersonalDetails);
  }

  suspendUser(user:User):Observable<User>
  {
    delete user['authorities'];
    return this.httpClient.post<User>('http://localhost:8080/suspendUser',  user);
  }

  resetPassword(user:User):Observable<User>
  {
    delete user['authorities'];
    return this.httpClient.post<User>('http://localhost:8080/changePassword',  user);
  }

  addNewUser(user:User):Observable<User>
  {
    delete user['authorities'];
    let sendUser=
      {
        "username":user.username,
        "password":user.username,
        "role":user.role,
        "accountNonLocked":true,
        "userPersonalDetails":{
        "firstName":user.firstName,
        "lastName":user.lastName,
          "phone":user.phone,
          "addressLine1":" ",
          "addressLine2":" ",
          "addressCity":" ",
          "addressState":" ",
          "addressCountry":" ",
          "addressZipCode":" "}
        
      }
    return this.httpClient.post<User>('http://localhost:8080' + this.roleCheck.getCreateURLByRole(user.role),  sendUser);
  }


}
