import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LinepService } from '../linep.service';
import { Lineprod } from '../lineprod';

@Component({
  selector: 'app-lineprodadd',
  templateUrl: './lineprodadd.component.html',
  styleUrls: ['./lineprodadd.component.css']
})
export class LineprodaddComponent implements OnInit {

  linep: Lineprod = new Lineprod();
  submitted = false;

  constructor(private lpserv: LinepService,
    private router: Router) { }

  ngOnInit() {
  }

  newlinep(): void {
    this.submitted = false;
    this.linep = new Lineprod();
  }

  save() {
    this.lpserv
    .createLineProd(this.linep).subscribe(data => {
      console.log(data)
      this.linep = new Lineprod();
      this.gotoList();
    }, 
    error => console.log(error));
  }

  onSubmit() {
    this.submitted = true;
    this.save();    
  }

  gotoList() {
    this.router.navigate(['/lineps']);
  }
}
