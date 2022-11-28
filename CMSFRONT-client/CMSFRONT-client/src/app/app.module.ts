import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule } from '@angular/router';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { HomeComponent } from './home/home.component';
import { ProfileComponent } from './profile/profile.component';
import { BoardAdminComponent } from './board-admin/board-admin.component';
import { BoardLinemanagerComponent } from './board-linemanager/board-linemanager.component';
import { BoardMachinistComponent } from './board-machinist/board-machinist.component';
import { authInterceptorProviders } from './_helpers/auth.interceptor';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { LineprodComponent } from './lineprod/lineprod.component';
import { MachinesComponent } from './machines/machines.component';
import { LineprodaddComponent } from './lineprodadd/lineprodadd.component';
import { LinepupdateComponent } from './linepupdate/linepupdate.component';
import { LinepdetailsComponent } from './linepdetails/linepdetails.component';
import { LineAuditComponent } from './line-audit/line-audit.component';
import { RevTypePipe } from './pipes/revtype/rev-type.pipe';
import { AdminLoginComponent } from './admin-login/admin-login.component';
import { MachineAddComponentComponent } from './machine-add-component/machine-add-component.component';
import { MachineUpdateComponentComponent } from './machine-update-component/machine-update-component.component';
import { MachdetailsComponent } from './machdetails/machdetails.component';
import { MachineauditComponent } from './machineaudit/machineaudit.component';
import { UserAddComponent } from './user-add/user-add.component';
import { UserUpdateComponent } from './user-update/user-update.component';
import { UserListComponent } from './user-list/user-list.component';
import { UserAuditComponent } from './user-audit/user-audit.component';
import { UserDetailsComponent } from './user-details/user-details.component';
@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent,
    HomeComponent,
    ProfileComponent,
    BoardAdminComponent,
    BoardLinemanagerComponent,
    BoardMachinistComponent,
    LineprodComponent,
    MachinesComponent,
    LineprodaddComponent,
    LinepupdateComponent,
    LinepdetailsComponent,
    LineAuditComponent,
    RevTypePipe,
    AdminLoginComponent,
    MachineAddComponentComponent,
    MachineUpdateComponentComponent,
    MachdetailsComponent,
    MachineauditComponent,
    UserAddComponent,
    UserUpdateComponent,
    UserListComponent,
    UserAuditComponent,
    UserDetailsComponent,

    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    RouterModule,
  ],
  providers: [authInterceptorProviders],
  bootstrap: [AppComponent]
})
export class AppModule { }
