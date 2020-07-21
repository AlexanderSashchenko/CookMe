import { Component, OnInit } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {AuthenticationService} from "../../services/authentication-service/authentication-service";
import {UserAuthenticationModel} from "../../models/user-authentication/user-authentication.model";
import {UserAuthenticationResponseModel} from "../../models/user-authentication-response/user-authentication-response.model";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent implements OnInit {

  userAuthentication: UserAuthenticationModel;
  userAuthenticationResponse: UserAuthenticationResponseModel;

  constructor(private http: HttpClient,
              private authenticationService: AuthenticationService) {
    this.userAuthentication = new UserAuthenticationModel();
  }

  ngOnInit(): void {
  }

  login(): void {
    this.authenticationService.authenticate(this.userAuthentication).subscribe(
      result => {
        console.log(result);
      },
      error => {
        console.log(error);
      }
    );
  }

  inject(): void {
    this.http.get("http://localhost:8080/inject").subscribe(
      result => {
        console.log(result);
      },
      error => {
        console.log(error);
      }
    );
  }
}
