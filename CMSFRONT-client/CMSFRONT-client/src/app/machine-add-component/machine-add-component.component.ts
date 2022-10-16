import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { LinepService } from '../linep.service';
import { Lineprod } from '../lineprod';
import { Machines } from '../machines';
import { MachinesService } from '../machines.service';

@Component({
  selector: 'app-machine-add-component',
  templateUrl: './machine-add-component.component.html',
  styleUrls: ['./machine-add-component.component.css']
})
export class MachineAddComponentComponent implements OnInit {

  linep: Machines = new Machines();
  submitted = false;
  lines!: Lineprod[];

  constructor(private lpserv: MachinesService, private lserv: LinepService,
    private router: Router) { }

  ngOnInit() {
    this.getLines();
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

  newlinep(): void {
    this.submitted = false;
    this.linep = new Machines();
  }

  save() {
    
    this.lpserv.createmach(this.linep).subscribe(data => {
      console.log(data)
      this.linep = new Machines();
      this.gotoList();
    },
      error => console.log(error));
  }

  onSubmit() {
    this.submitted = true;
    console.log(this.linep);
    
    this.save();
  }
  setLine(line : Lineprod){
    this.linep.line=line;
  }
setType(pp:string)
{
  this.linep.typemach=pp;
}

  gotoList() {
    this.router.navigate(['/machines']);
  }

}
