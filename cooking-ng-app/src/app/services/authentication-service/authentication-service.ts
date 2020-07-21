import {HttpClient} from "@angular/common/http";
import {UserAuthenticationModel} from "../../models/user-authentication/user-authentication.model";
import {Observable} from "rxjs";
import {UserAuthenticationResponseModel} from "../../models/user-authentication-response/user-authentication-response.model";
import {Injectable} from "@angular/core";

@Injectable({
  providedIn:'root'
})
export class AuthenticationService {
  private readonly authenticationUrl: string;

  constructor(private http: HttpClient) {
    this.authenticationUrl = 'http://localhost:8080/authentication';
  }

  public authenticate(userAuthenticationModel: UserAuthenticationModel)
    : Observable<UserAuthenticationResponseModel[]> {
    return this.http.post<UserAuthenticationResponseModel[]>(
      this.authenticationUrl, userAuthenticationModel);
  }
}
