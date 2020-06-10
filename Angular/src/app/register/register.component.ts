import { Component, OnInit } from '@angular/core';
import { AddscheduledflyService } from '../addscheduledfly.service';
import { HttpClient } from '@angular/common/http';
import { NgForm } from '@angular/forms';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  success: string;
  failure: string;

  constructor(private register: AuthService, private http: HttpClient) { }

  ngOnInit() {
    }

    registerForm(form: NgForm) {
      this.register.registerForm(form.value).subscribe(data => {
        console.log(data);
        if (data.statusCode === 201) {
          this.success = data.description;
          setTimeout(() => {
            this.success = null;
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

