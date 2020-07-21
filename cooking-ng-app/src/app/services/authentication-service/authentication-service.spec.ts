import {AuthenticationService} from "./authentication-service";
import {TestBed} from "@angular/core/testing";

describe('AuthenticationService', () => {
  let authService: AuthenticationService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    authService = TestBed.inject(AuthenticationService);
  });

  it('should be created', () => {
    expect(authService).toBeTruthy();
  });
});
