import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BoardAdminComponent } from './board-admin/board-admin.component';
import { BoardLinemanagerComponent } from './board-linemanager/board-linemanager.component';
import { BoardMachinistComponent } from './board-machinist/board-machinist.component';
import { HomeComponent } from './home/home.component';
import { LineAuditComponent } from './line-audit/line-audit.component';
import { LinepdetailsComponent } from './linepdetails/linepdetails.component';
import { LineprodComponent } from './lineprod/lineprod.component';
import { LineprodaddComponent } from './lineprodadd/lineprodadd.component';
import { LinepupdateComponent } from './linepupdate/linepupdate.component';
import { LoginComponent } from './login/login.component';
import { ProfileComponent } from './profile/profile.component';
import { RegisterComponent } from './register/register.component';

const routes: Routes = [
  { path: 'home', component: HomeComponent },
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'profile', component: ProfileComponent },
  { path: 'user', component: BoardMachinistComponent },
  { path: 'mod', component: BoardLinemanagerComponent },
  { path: 'lineps', component: LineprodComponent },
  { path: 'linepadd', component: LineprodaddComponent },
  { path: 'linepupdate/:id', component: LinepupdateComponent },
  { path: 'linepdetails/:id', component: LinepdetailsComponent },
  { path: 'linepaudit/:id', component: LineAuditComponent },

  { path: 'admin', component: BoardAdminComponent },
  { path: '', redirectTo: 'home', pathMatch: 'full' }
];
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
