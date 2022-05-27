import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { LinepService } from '../linep.service';
import { Lineprod } from '../lineprod';

@Component({
  selector: 'app-linepdetails',
  templateUrl: './linepdetails.component.html',
  styleUrls: ['./linepdetails.component.css']
})
export class LinepdetailsComponent implements OnInit {
  id !: number;
  lprod !: Lineprod;
  lineaud !: Observable<Lineprod[]>;

  constructor(private route: ActivatedRoute,private router: Router,
    private lpserv: LinepService) { }

  ngOnInit() {
    this.lprod = new Lineprod();

    this.id = this.route.snapshot.params['id'];
    
    this.lpserv.getLineProd(this.id)
      .subscribe(data => {
        console.log(data)
        this.lprod = data;
      }, error => console.log(error));
  }
 

  list(){
    this.router.navigate(['lineps']);
  }
  linepaudits(id : number){
    this.router.navigate(['linepaudit', id]);
  }
}
