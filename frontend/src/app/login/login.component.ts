import { Component, OnInit } from '@angular/core';
import { AuthService } from '../_services/auth.service';
import { TokenStorageService } from '../_services/token-storage.service'

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit{
  loginForm: any = {
    username: null,
    password: null
  };
  isLoggedIn = false;
  isLoginFailed = false;
  loginErrorMessage = '';
  roles: string[] = [];
  username?: string;

  signupForm: any = {
    username: null,
    email: null,
    password: null
  };
  isSuccessful = false;
  isSignUpFailed = false;
  signupErrorMessage = '';

  constructor(private authService: AuthService, private tokenStorage: TokenStorageService) { }

  ngOnInit(): void {
    if (this.tokenStorage.getToken()) {
      this.isLoggedIn = true;
      const user = this.tokenStorage.getUser();
      this.username = user.username;
      this.roles = user.roles;
    }
  }

  onSubmitLogin(): void {
    const { username, password } = this.loginForm;

    this.authService.login(username, password).subscribe(
      data => {
        this.tokenStorage.saveToken(data.accessToken);
        this.tokenStorage.saveUser(data);

        this.isLoginFailed = false;
        this.isLoggedIn = true;
        this.roles = this.tokenStorage.getUser().roles;
        window.location.assign('home');
      },
      err => {
        if(err.error)this.loginErrorMessage = err.error.message;
        this.isLoginFailed = true;
      }
    );
  }

  onSubmitSignup(): void {
    const { username, email, password } = this.signupForm;

    this.authService.register(username, email, password).subscribe(
      data => {
        this.isSuccessful = true;
        this.isSignUpFailed = false;
        window.location.reload();
      },
      err => {
        if (err.error) this.signupErrorMessage = err.error.message;
        this.isSignUpFailed = true;
      }
    );
  }

}
