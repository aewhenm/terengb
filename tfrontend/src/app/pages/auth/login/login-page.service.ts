import { Inject, Injectable } from '@angular/core';
import { HttpService } from '@core/http.service';
import { environment } from '../../../../environments/environment';
import { DOCUMENT } from '@angular/common';
import { HTTPUtils } from '../../../util/HTTPUtils';

@Injectable({
  providedIn: 'root'
})
export class LoginPageService {

  private http: HttpService;

  constructor(private httpServiceCore: HttpService,
              @Inject(DOCUMENT) private document: Document) {
    this.http = httpServiceCore.setControllerPrefix('/company');
  }

  redirectToInstaWindow() {
    const params = new Map<string, string>();
    params.set('client_id', environment.fbDevClientId);
    params.set('redirect_uri', environment.instaAuthRedirectUrl);
    params.set('scope', 'user_profile'); // todo: anything else needed!?
    params.set('response_type', 'code'); // constant

    console.log(HTTPUtils.toUrlSearchParams(params));
    this.document.location.href = environment.instaAuthWindowUrl + HTTPUtils.toUrlSearchParams(params);
  }

}
