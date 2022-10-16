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
  lprod !: Machines;
  lineaud !: any[];
    constructor(private lprodserv: MachinesService,
    private router: Router,
    private route : ActivatedRoute) { }

  ngOnInit(): void {
    this.route.paramMap.subscribe({
      next : (res : any) => {
        this.getauditList(res.get('id')); 
      }
    })
    
  }

getauditList(id:number){
  this.lprodserv.getAudits(id).subscribe({
    next : (res : any) => {
      this.lineaud = res
      this.lineaud = this.lineaud.map(line =>  new Machaudit(
          line[0], 
          line[1], 
          line[2], 
          line[3], 
          line[4],
          line[5],
          line[6],
          line[7],
          line[8],
          line[9],

        ))
    },
    error : (err : any)=> {

    }

  })
 
}

}
