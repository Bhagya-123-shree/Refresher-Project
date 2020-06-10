import { Component, OnInit } from '@angular/core';
import { AddscheduledflyService } from '../addscheduledfly.service';
import { Router, ActivatedRoute } from '@angular/router';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-updatescheduledflight',
  templateUrl: './updatescheduledflight.component.html',
  styleUrls: ['./updatescheduledflight.component.css']
})
export class UpdatescheduledflightComponent implements OnInit {
  scheduledFId1;
  flightName1;
  source1;
  destination1;
  departureDate1;
  departureTime1;
  arrivalDate1;
  arrivalTime1;
  availableSeats1;

  constructor(private flight: AddscheduledflyService,
              private router: Router,
              activatedRoute: ActivatedRoute) {
    activatedRoute.params.subscribe(data => {
      console.log(data.scheduledFId);
    });
    activatedRoute.queryParams.subscribe(data => {
      console.log(data);
      this.scheduledFId1 = data.scheduledFId;
      this.flightName1 = data.flightName;
      this.source1 = data.source;
      this.departureDate1 = data.departureDate;
      this.arrivalDate1 = data.arrivalDate;
      this.departureTime1 = data.departureTime;
      this.arrivalTime1 = data.arrivalTime;
      this.availableSeats1 = data.availableSeats;
    });
  }

  ngOnInit() {
  }

  updateScheduledFlight(form: NgForm) {
    console.log(form.value);
    this.flight.addScheduledFlight(form.value).subscribe(data => {
      console.log(data);
      this.router.navigateByUrl('/getAllFlight');
    });
  }

}
