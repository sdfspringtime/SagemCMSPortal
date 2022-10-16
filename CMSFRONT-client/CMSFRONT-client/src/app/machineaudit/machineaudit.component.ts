import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { Machaudit } from '../machaudit';
import { Machines } from '../machines';
import { MachinesService } from '../machines.service';

@Component({
  selector: 'app-machineaudit',
  templateUrl: './machineaudit.component.html',
  styleUrls: ['./machineaudit.component.css']
})
export class MachineauditComponent implements OnInit {

  id !: number;
  machine !: Machines;
  machaud !: any[];
  constructor(private machineserv: MachinesService,
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
    this.machineserv.getmach(this.id).subscribe({
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
    this.machaud = this.machaud.map(value => new Machaudit(value[0], value[1], value[5], value[3], value[10], value[6], value[7], value[9], value[8], value[2], value[4]

        ))
      },
      error: (err: any) => {

      }

    })

  }

}
