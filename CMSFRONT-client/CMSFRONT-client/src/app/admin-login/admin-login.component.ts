import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from '../user';
import { AdminLoginServiceService } from '../_services/admin-login-service.service';
import { TokenStorageService } from '../_services/token-storage.service';

@Component({
  selector: 'app-admin-login',
  templateUrl: './admin-login.component.html',
  styleUrls: ['./admin-login.component.css']
})
export class AdminLoginComponent implements OnInit {
  form: any = {
    username: null,
    password: null
  };
  isLoggedIn = false;
  isLoginFailed = false;
  errorMessage = '';
  roles: string[] = [];

  user: User = new User;
  constructor(private ALserv:AdminLoginServiceService,private tservice:TokenStorageService, private router : Router) {
   
 
  
   }
   ngOnInit(): void {
    if (this.tservice.getToken()) {
      this.isLoggedIn = true;
      this.roles = this.tservice.getUser().roles;
      }

  }
   onSubmit():void{
   
    const { username, password } = this.form;
    this.ALserv.signIn(username,password).subscribe({
      next: (res: any) => {
        console.log(res)
        this.tservice.saveToken(res.accessToken);
        this.user.email = res.email;
        this.user.username = res.username;
        this.user.roles = [res.roles];

        this.roles = [res.roles];
        this.isLoginFailed = false;
        this.isLoggedIn = true;
        this.tservice.saveUser(this.user);
        setTimeout(()=>{
          this.router.navigate(["home"])
        }, 3000)
      },
      error: (err: any) => {

        this.ALserv.handleError(err);

      }
    });
    //this.reloadPage();

   }

   reloadPage(){
    window.location.reload();

   }

}


