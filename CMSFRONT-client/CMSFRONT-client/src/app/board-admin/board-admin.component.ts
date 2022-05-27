import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { LinepService } from '../linep.service';
import { Lineprod } from '../lineprod';

@Component({
  selector: 'app-board-admin',
  templateUrl: './board-admin.component.html',
  styleUrls: ['./board-admin.component.css']
})
export class BoardAdminComponent implements OnInit {

  linep: Observable<Lineprod[]>;

  constructor(private lprodserv: LinepService,
    private router: Router) {}

  ngOnInit() {
    this.reloadData();
  }

  reloadData() {
    this.linep = this.lprodserv.getlprodList();
  }

  deletelprod(id: number) {
    this.lprodserv.deletelprod(id)
      .subscribe(
        data => {
          console.log(data);
          this.reloadData();
        },
        error => console.log(error));
  }

  LprodDetails(id: number){
    this.router.navigate(['linepdetails', id]);
  }

}
