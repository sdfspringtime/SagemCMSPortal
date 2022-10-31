import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { User1 } from '../user1';
import { Useraudit } from '../useraudit';
import { UserservService } from '../userserv.service';

@Component({
  selector: 'app-user-audit',
  templateUrl: './user-audit.component.html',
  styleUrls: ['./user-audit.component.css']
})
export class UserAuditComponent implements OnInit {

  id !: number;
  machine !: User1;
  machaud !: any[];
  constructor(private machineserv: UserservService,
    private router: Router,
    private route: ActivatedRoute) { }

  getMachIdFromParams() {
    this.route.paramMap.subscribe({
      next: (res: any) => {
        this.id = res.get('id');
      }
    }
    )
  }
  ngOnInit(): void {
    this.getMachIdFromParams();
    this.route.paramMap.subscribe({
      next: (res: any) => {
        this.getauditList(this.id);
      }
    })
    this.machineserv.getLineProd(this.id).subscribe({
      next : (res : any) => {
        this.machine = res;
      },
      error : (err : any) =>{
        console.log(err)
      }
    })


  }

  getauditList(id: number) {
    this.machineserv.getAudits(id).subscribe({
      next: (res: any) => {
        this.machaud = res
    this.machaud = this.machaud.map(value => new Useraudit(value[0], value[1], value[2], value[3], value[4], value[5]

        ))
      },
      error: (err: any) => {

      }

    })

  }

}

