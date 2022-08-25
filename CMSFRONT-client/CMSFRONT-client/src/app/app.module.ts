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
