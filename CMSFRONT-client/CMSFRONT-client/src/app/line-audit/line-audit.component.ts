import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { lineaudit } from 'src/lineaudit';
import { LinepService } from '../linep.service';
import { Lineprod } from '../lineprod';

@Component({
  selector: 'app-line-audit',
  templateUrl: './line-audit.component.html',
  styleUrls: ['./line-audit.component.css']
})
export class LineAuditComponent implements OnInit {
  id !: number;
  lprod !: Lineprod;
  lineaud !: any[];
    constructor(private lprodserv: LinepService,
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
      this.lineaud = this.lineaud.map(line =>  new lineaudit(
          line[0], 
          line[1], 
          line[2], 
          line[3], 
          line[4],
          line[5],
        ))
    },
    error : (err : any)=> {

    }

  })
 
}


}
