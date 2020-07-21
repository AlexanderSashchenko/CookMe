import { Component, OnInit } from '@angular/core';
import {UserRegistrationModel} from "../../models/user-registration/user-registration.model";
import {UserResponseModel} from "../../models/user-response/user-response.model";
import {RegistrationService} from "../../services/registration-service/registration.service";
import {Observable} from "rxjs";

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css'],
})
export class RegisterComponent implements OnInit {

  userRegistration: UserRegistrationModel;
  user: Observable<UserResponseModel[]>;

  constructor(private registrationService: RegistrationService) {
    this.userRegistration = new UserRegistrationModel();
  }

  ngOnInit(): void {
  }

  register(): void {
    this.user = this.registrationService.register(this.userRegistration);
    this.show()
    this.user.subscribe(result => {
        console.log(result);
      },
      error => {
        console.log(error);
      }
    );
  }

  show(): void {
    console.log(this.userRegistration)
  }
}
