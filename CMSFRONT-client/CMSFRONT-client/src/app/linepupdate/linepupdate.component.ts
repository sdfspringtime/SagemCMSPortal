import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { LinepService } from '../linep.service';
import { Lineprod } from '../lineprod';

@Component({
  selector: 'app-linepupdate',
  templateUrl: './linepupdate.component.html',
  styleUrls: ['./linepupdate.component.css']
})
export class LinepupdateComponent implements OnInit {
  id: number;
  lprod: Lineprod;

  constructor(private route: ActivatedRoute,private router: Router,
    private lprodserv: LinepService) { }

  ngOnInit() {
    this.lprod = new Lineprod();

    this.id = this.route.snapshot.params['id'];
    
    this.lprodserv.getLineProd(this.id)
      .subscribe(data => {
        console.log(data)
        this.lprod = data;
      }, error => console.log(error));
  }

  updateLprod() {
    this.lprodserv.updateLineProd(this.id, this.lprod)
      .subscribe(data => {
        console.log(data);
        this.lprod = new Lineprod();
        this.gotoList();
      }, error => console.log(error));
  }
  gotoList() {
    this.router.navigate(['lineps']);
  }
  onSubmit() {
    this.updateLprod();    
  }
 

}
