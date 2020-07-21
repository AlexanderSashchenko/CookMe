import {HttpClient} from "@angular/common/http";
import {Injectable} from "@angular/core";
import {UserRegistrationModel} from "../../models/user-registration/user-registration.model";
import {Observable} from "rxjs";
import {UserResponseModel} from "../../models/user-response/user-response.model";

@Injectable({
  providedIn:"root"
})
export class RegistrationService {
  private readonly registrationUrl: string;

  constructor(private http: HttpClient) {
    this.registrationUrl = 'http://localhost:8080/registration';
  }

  public register(userRegistrationModel: UserRegistrationModel): Observable<UserResponseModel[]> {
    return this.http.post<UserResponseModel[]>(this.registrationUrl, userRegistrationModel);
  }
}
