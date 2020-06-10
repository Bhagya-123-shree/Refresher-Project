import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule} from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';


import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { AddscheduledflightComponent } from './addscheduledflight/addscheduledflight.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { HeaderComponent } from './header/header.component';
import { UpdatescheduledflightComponent } from './updatescheduledflight/updatescheduledflight.component';
import { ContactusComponent } from './contactus/contactus.component';
import { AdminhomeComponent } from './adminhome/adminhome.component';
import { FlightdetailComponent } from './flightdetail/flightdetail.component';
import { PagenotfoundComponent } from './pagenotfound/pagenotfound.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    AddscheduledflightComponent,
    LoginComponent,
    RegisterComponent,
    HeaderComponent,
    UpdatescheduledflightComponent,
    ContactusComponent,
    AdminhomeComponent,
    FlightdetailComponent,
    PagenotfoundComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
