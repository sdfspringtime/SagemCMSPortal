import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { LinepService } from '../linep.service';
import { Lineprod } from '../lineprod';
import { Machines } from '../machines';
import { MachinesService } from '../machines.service';

@Component({
  selector: 'app-machine-update-component',
  templateUrl: './machine-update-component.component.html',
  styleUrls: ['./machine-update-component.component.css']
})
export class MachineUpdateComponentComponent implements OnInit {

  id: number;
  lprod: Machines;
  lines!: Lineprod[];
  linep:Lineprod;
  constructor(private route: ActivatedRoute,private router: Router,
    private lprodserv: MachinesService,private lserv:LinepService) { }

  ngOnInit() {
    this.lprod = new Machines();
this.getLines();
    this.id = this.route.snapshot.params['id'];
    
    this.lprodserv.getmach(this.id)
      .subscribe(data => {
        console.log(data)
        this.lprod = data;
      }, error => console.log(error));
  }
  getLines() {
    this.lserv.getlprodList().subscribe({
      next: (data) => {
        this.lines = data;
        console.log(data);

      },
      error: (err) => {
        console.log(err)
      }
    })
  }
  updateLprod() {
    this.lprodserv.updatemach(this.id, this.lprod)
      .subscribe(data => {
        console.log(data);
        this.lprod = new Machines();
        this.gotoList();
      }, error => console.log(error));
  }
  setLine(line : Lineprod){
    
    this.lprod.line=line;
  }
setType(pp:string)
{
  this.lprod.typemach=pp;
}
  gotoList() {
    this.router.navigate(['machines']);
  }
  onSubmit() {
    this.updateLprod();    
  }
 

}