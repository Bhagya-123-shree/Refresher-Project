import { Component, OnInit } from '@angular/core';
import { AddscheduledflyService } from '../addscheduledfly.service';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';


@Component({
  selector: 'app-flightdetail',
  templateUrl: './flightdetail.component.html',
  styleUrls: ['./flightdetail.component.css']
})
export class FlightdetailComponent implements OnInit {
  success: string;
  failure: string;
  schedules: ScheduledFlight[];

  constructor(private scheduleDet: AddscheduledflyService,
              private router: Router , private http: HttpClient) {
this.getFlights();
  }
  getFlights() {
    this.scheduleDet.getAllFlight().subscribe(response => {
      console.log(response);
      if (response.statusCode === 201) {
        this.schedules = response.flightList;
        this.success = response.description;
        localStorage.setItem('schedule details', JSON.stringify(response));
        setTimeout(() => {
          this.success = null;

        }, 2000);
      } else {
         this.failure = response.description;
         localStorage.setItem('schedule details', JSON.stringify(response));
         console.log('flight details here');
         setTimeout(() => {
          this.success = null;

        }, 2000);

      }
    });
  }

  deleteSchdeule(flight: ScheduledFlight) {
    console.log(flight);

    this.scheduleDet.deleteSchedule(flight).subscribe(data => {
      console.log(data);
      if (data.statusCode === 201) {
        this.schedules.splice(this.schedules.indexOf(flight), 1);
        this.success = data.flight;
        setTimeout(() => {
          this.success = null;
        }, 2000);
      }
    });
  }

  ngOnInit() {
  }

}
