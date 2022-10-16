import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { lineaudit } from 'src/lineaudit';
import { Machines } from '../machines';
import { MachinesService } from '../machines.service';
import { TokenStorageService } from '../_services/token-storage.service';

@Component({
  selector: 'app-machines',
  templateUrl: './machines.component.html',
  styleUrls: ['./machines.component.css']
})
export class MachinesComponent implements OnInit {


  linep!: Observable<Machines[]>;
  private roles: string[] = [];
  isLoggedIn = false;
  showAdminBoard = false;
  showModeratorBoard = false;
  username?: string;
  lineaud !: Observable<lineaudit[]>;

 
    
  

  constructor(private machserv: MachinesService,private tokenStorageService: TokenStorageService,
    private router: Router) {}
    
  deletelprod(id: number) {
    this.machserv.deletemach(id)
      .subscribe(
        data => {
          console.log(data);
          this.reloadData();
        },
        error => console.log(error));
  }
 LprodAudit(id:number){
   this.router.navigate(['machaudit',id]);
 }

  LprodDetails(id: number){
    this.router.navigate(['machdetails', id]);
  }
  
  Lprodupdate(id: number){
    this.router.navigate(['machupdate', id]);
  }

    reloadData() {
      this.linep = this.machserv.getmachList();
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

  
  }

}
