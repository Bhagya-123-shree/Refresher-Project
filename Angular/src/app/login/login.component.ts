import { Component, OnInit } from '@angular/core';
import { AuthService } from '../auth.service';
import { Router } from '@angular/router';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  error: any;
  message: any;


  constructor(
    private auth: AuthService,
    private router: Router
  ) { }

  login(form: NgForm) {
    this.auth.login(form.value).subscribe(res => {
      console.log(res);
      if (res.statusCode === 201) {
        if (res.login[0].role === 'admin') {
          form.reset();
          this.message = 'you are logged in successfully';
          setTimeout(() => {
            this.message = null;
          }, 5000);
          console.log(res);

          localStorage.setItem('flight', JSON.stringify(res));
          console.log('user details stored in local storage');
          this.router.navigateByUrl('/adminhome');

        }
      } else {
        form.reset();
        this.error = 'sorry...!!! PLEASE PROVIDE VALID CREDENTIALS';
        setTimeout(() => {
          this.error = null;
        }, 5000);
      }
    }, err => {
      this.error = 'sorry...!!! PLEASE PROVIDE VALID CREDENTIALS';
      setTimeout(() => {
        this.error = null;
    }, 3000);
  });
}

ngOnInit() {
}
}
