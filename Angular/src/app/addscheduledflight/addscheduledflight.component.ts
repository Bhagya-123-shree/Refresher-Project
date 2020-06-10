import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { NgForm } from '@angular/forms';
import { AddscheduledflyService } from '../addscheduledfly.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-addscheduledflight',
  templateUrl: './addscheduledflight.component.html',
  styleUrls: ['./addscheduledflight.component.css']
})
export class AddscheduledflightComponent implements OnInit {
  success: string;
  failure: string;

  constructor(private flight: AddscheduledflyService, private http: HttpClient,private router:Router) { }

  ngOnInit() {
  }

  addScheduledFlight(form: NgForm) {
    this.flight.addScheduledFlight(form.value).subscribe(data => {
      console.log(data);
      if (data.statusCode === 201) {
        this.success = data.description;
        setTimeout(() => {
          this.success = null;
          this.router.navigateByUrl('/adminhome')
        }, 2000);
        form.reset();
      } else {
        this.failure = data.description;
        setTimeout(() => {
          this.failure = null;
        }, 2000);
      }
    });
  }
}
