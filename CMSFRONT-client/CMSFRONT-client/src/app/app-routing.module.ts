import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminLoginComponent } from './admin-login/admin-login.component';
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
import { MachdetailsComponent } from './machdetails/machdetails.component';
import { MachineAddComponentComponent } from './machine-add-component/machine-add-component.component';
import { MachineUpdateComponentComponent } from './machine-update-component/machine-update-component.component';
import { MachineauditComponent } from './machineaudit/machineaudit.component';
import { MachinesComponent } from './machines/machines.component';
import { ProfileComponent } from './profile/profile.component';
import { RegisterComponent } from './register/register.component';
import { UserAddComponent } from './user-add/user-add.component';
import { UserAuditComponent } from './user-audit/user-audit.component';
import { UserDetailsComponent } from './user-details/user-details.component';
import { UserListComponent } from './user-list/user-list.component';
import { UserUpdateComponent } from './user-update/user-update.component';

const routes: Routes = [
  { path: 'home', component: HomeComponent },
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'profile', component: ProfileComponent },
  { path: 'user', component: BoardMachinistComponent },
  { path: 'mod', component: BoardLinemanagerComponent },
  { path: 'lineps', component: LineprodComponent },
  { path: 'linepadd', component: LineprodaddComponent },
  { path: 'alogin', component: AdminLoginComponent },
  { path: 'linepupdate/:id', component: LinepupdateComponent },
  { path: 'linepdetails/:id', component: LinepdetailsComponent },
  { path: 'linepaudit/:id', component: LineAuditComponent },
  { path: 'machupdate/:id', component: MachineUpdateComponentComponent },
  { path: 'machdetails/:id', component:  MachdetailsComponent},
  { path: 'machaudit/:id', component: MachineauditComponent },
  { path: 'machines', component: MachinesComponent },
  { path: 'machadd', component: MachineAddComponentComponent },
  { path: 'admin', component: BoardAdminComponent },
  { path: 'userdetails/:id', component: UserDetailsComponent },
  { path: 'userupdate/:id', component: UserUpdateComponent },
  { path: 'useraudit/:id', component: UserAuditComponent },
  { path: 'users', component: UserListComponent },
  { path: 'useradd', component: UserAddComponent },
  { path: '', redirectTo: 'home', pathMatch: 'full' }
];
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
