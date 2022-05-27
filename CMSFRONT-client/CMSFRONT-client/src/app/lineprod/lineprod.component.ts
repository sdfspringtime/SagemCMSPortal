import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { lineaudit } from 'src/lineaudit';
import { LinepService } from '../linep.service';
import { Lineprod } from '../lineprod';
import { TokenStorageService } from '../_services/token-storage.service';

@Component({
  selector: 'app-lineprod',
  templateUrl: './lineprod.component.html',
  styleUrls: ['./lineprod.component.css']
})
export class LineprodComponent implements OnInit {

  linep!: Observable<Lineprod[]>;
  private roles: string[] = [];
  isLoggedIn = false;
  showAdminBoard = false;
  showModeratorBoard = false;
  username?: string;
  lineaud !: Observable<lineaudit[]>;

 
    
  

  constructor(private lprodserv: LinepService,private tokenStorageService: TokenStorageService,
    private router: Router) {}
    
  deletelprod(id: number) {
    this.lprodserv.deletelprod(id)
      .subscribe(
        data => {
          console.log(data);
          this.reloadData();
        },
        error => console.log(error));
  }
 LprodAudit(id:number){
   this.router.navigate(['linepaudit',id]);
 }

  LprodDetails(id: number){
    this.router.navigate(['linepdetails', id]);
  }
  
  Lprodupdate(id: number){
    this.router.navigate(['linepupdate', id]);
  }

    reloadData() {
      this.linep = this.lprodserv.getlprodList();
    }
  ngOnInit() {

    this.isLoggedIn = !!this.tokenStorageService.getToken();

    if (this.isLoggedIn) {
      const user = this.tokenStorageService.getUser();
      this.roles = user.roles;

      this.showAdminBoard = this.roles.includes('ROLE_ADMIN');
      this.showModeratorBoard = this.roles.includes('ROLE_MACHINIST');

      this.username = user.username;
    this.reloadData();
  }

  

  }}
