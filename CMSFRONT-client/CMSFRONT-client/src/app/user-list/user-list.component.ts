import { ValueConverter } from '@angular/compiler/src/render3/view/template';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { roles } from '../roles';
import { User } from '../user';
import { User1 } from '../user1';
import { map } from "rxjs/operators";

import { UserservService } from '../userserv.service';
import { TokenStorageService } from '../_services/token-storage.service';

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css']
})
export class UserListComponent implements OnInit {
Role!:roles;
  linep!: Observable<User1[]>;
   roles!: roles[];
  isLoggedIn = false;
  showAdminBoard = false;
  showModeratorBoard = false;
  username?: string;

 
    
  

  constructor(private machserv: UserservService,private tokenStorageService: TokenStorageService,
    private router: Router) {

      
    }
    
  deletelprod(id: number) {
    this.machserv.deletelprod(id)
      .subscribe(
        data => {
          console.log(data);
          this.reloadData();
        },
        error => console.log(error));
  }
 LprodAudit(id:number){
   this.router.navigate(['useraudit',id]);
 }

  LprodDetails(id: number){
    this.router.navigate(['userdetails', id]);
  }
  
  Lprodupdate(id: number){
    this.router.navigate(['userupdate', id]);
  }

    reloadData() {
      this.linep = this.machserv.getlprodList();
      
    
    }
  ngOnInit() {

 
    this.reloadData();
  }

  
  }



