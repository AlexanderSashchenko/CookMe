import {RegistrationService} from "./registration.service";
import {TestBed} from "@angular/core/testing";

describe('RegistrationService', () => {
  let registrationService: RegistrationService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    registrationService = TestBed.inject(RegistrationService);
  });

  it('should be created', () => {
    expect(registrationService).toBeTruthy();
  });
});
