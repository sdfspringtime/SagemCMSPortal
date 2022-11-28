import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { LinepService } from '../linep.service';
import { Machines } from '../machines';
import { MachinesService } from '../machines.service';

@Component({
  selector: 'app-machdetails',
  templateUrl: './machdetails.component.html',
  styleUrls: ['./machdetails.component.css']
})
export class MachdetailsComponent implements OnInit {

  id !: number;
  lprod !: Machines;
  lineaud !: Observable<Machines[]>;

  constructor(private route: ActivatedRoute,private router: Router,
    private lpserv: MachinesService,private mserv:LinepService) { }

  ngOnInit() {
    this.lprod = new Machines();

    this.id = this.route.snapshot.params['id'];
    
    this.lpserv.getmach(this.id)
      .subscribe(data => {
        console.log(data)
        this.lprod = data;
      }, error => console.log(error));
      
  }
 

  list(){
    this.router.navigate(['machines']);
  }
  linepaudits(id : number){
    this.router.navigate(['machaudit', id]);
  }
}
