import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { roles } from '../roles';
import { User } from '../user';
import { User1 } from '../user1';
import { UserservService } from '../userserv.service';

@Component({
  selector: 'app-user-details',
  templateUrl: './user-details.component.html',
  styleUrls: ['./user-details.component.css']
})
export class UserDetailsComponent implements OnInit {
  Roles!: roles[];
  id !: number;
  lprod !: User1;
  lineaud !: Observable<User1[]>;

  constructor(private route: ActivatedRoute,private router: Router,
    private lpserv: UserservService) { }

  ngOnInit() {
    this.lprod = new User1();

    this.id = this.route.snapshot.params['id'];
    
    this.lpserv.getLineProd(this.id)
      .subscribe(data => {
        console.log(data)
        this.lprod = data;
      }, error => console.log(error));
      
     this.lpserv.getRoles(this.id).subscribe({
        next: (data: any) => {
          this.Roles=data
          console.log(data)  }})
          this.lprod.roles=this.Roles;}
 
          
          
  list(){
    this.router.navigate(['users']);
  }
  linepaudits(id : number){
    this.router.navigate(['useraudit', id]);
  }
}


