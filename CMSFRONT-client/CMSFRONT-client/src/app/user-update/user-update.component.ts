import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { LinepService } from '../linep.service';
import { roles } from '../roles';
import { User } from '../user';
import { User1 } from '../user1';
import { UserservService } from '../userserv.service';

@Component({
  selector: 'app-user-update',
  templateUrl: './user-update.component.html',
  styleUrls: ['./user-update.component.css']
})
export class UserUpdateComponent implements OnInit {

  id: number;
  lprod: User1;
  lines!: roles[];
  linep:roles;
  constructor(private route: ActivatedRoute,private router: Router,
    private lprodserv: UserservService) { }

  ngOnInit() {
    this.lprod = new User1();
this.getLines();
    this.id = this.route.snapshot.params['id'];
    
    this.lprodserv.getLineProd(this.id)
      .subscribe(data => {
        console.log(data)
        this.lprod = data;
      }, error => console.log(error));
  }
  getLines() {
    this.lprodserv.getRoles1().subscribe({
      next: (data:any) => {
        this.lines = data;
        console.log(data);

      },
      error: (err:any) => {
        console.log(err)
      }
    })
  }
  updateLprod() {
    this.lprodserv.updateLineProd(this.id, this.lprod)
      .subscribe((data:any) => {
        console.log(data);
        this.lprod = new User1();
        this.gotoList();
      }, (error:any) => console.log(error));
  }
  setLine(line : roles){
    let r1:roles[]=[]
    r1.push(line)
    this.lprod.roles=r1;
  }

  gotoList() {
    this.router.navigate(['users']);
  }
  onSubmit() {
    this.updateLprod();    
  }

}
