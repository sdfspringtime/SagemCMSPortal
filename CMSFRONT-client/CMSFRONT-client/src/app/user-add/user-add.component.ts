import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { roles } from '../roles';
import { User } from '../user';
import { User1 } from '../user1';
import { UserservService } from '../userserv.service';

@Component({
  selector: 'app-user-add',
  templateUrl: './user-add.component.html',
  styleUrls: ['./user-add.component.css']
})
export class UserAddComponent implements OnInit {
  Role!: roles;
  user: User1 = new User1();
  
  submitted = false;
  Roles!: roles[];

  constructor(private userv: UserservService,
    private router: Router) {
     }

  ngOnInit() {
    this.getLines();
    this.user.roles=this.Roles;

  }

  getLines() {
    this.userv.getRoles1().subscribe({
      next: (data: any) => {
        console.log(data)
        this.Roles = data.filter((role: any) => {
          if((role.name == "ROLE_MACHINIST") || (role.name == "ROLE_LMANAGER"))  {
            return role;
          }
        })
      }
    ,
      error: (err) => {
        console.log(err)
      }
    })
}

newuser(): void {
  this.submitted = false;
  this.user = new User1();
}


save() {
  this.userv.createLineProd(this.user).subscribe(data => {
    console.log(data)
    this.user = new User1();
    // this.userv.getRoles(this.user.id).subscribe(data=>{
    //   this.user.roles=data;
      //console.log(data);
   // })
    this.gotoList();
  },
    error => console.log(error));
}

onSubmit() {
  this.submitted = true;
  console.log(this.user);

  this.save();
}
setLine(role: roles) {
  let r1: roles[]=[];
  r1.push(role);
  this.user.roles=r1;
}


gotoList() {
  this.router.navigate(['users']);
}

}
