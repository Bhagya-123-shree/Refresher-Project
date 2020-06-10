import { NgModule, Component } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { AddscheduledflightComponent } from './addscheduledflight/addscheduledflight.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { UpdatescheduledflightComponent } from './updatescheduledflight/updatescheduledflight.component';
import { ContactusComponent } from './contactus/contactus.component';
import { AdminhomeComponent } from './adminhome/adminhome.component';
import { FlightdetailComponent } from './flightdetail/flightdetail.component';


const routes: Routes = [

  { path: '', component: HomeComponent },
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'add-scheduledflight', component: AddscheduledflightComponent },
  { path: 'update-scheduledflight', component: UpdatescheduledflightComponent },
  { path: 'adminhome', component: AdminhomeComponent},
  { path: 'contact-us', component: ContactusComponent},
  { path: 'flightdetail', component: FlightdetailComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
