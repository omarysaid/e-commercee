// addusers.component.ts

import { Component } from '@angular/core';
import { UsersService } from '../users.service';
import { Router } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-addusers',
  templateUrl: './addusers.component.html',
  styleUrls: ['./addusers.component.css']
})
export class AddusersComponent {
  PostusersForm: FormGroup;

  constructor(private userService: UsersService, private fb: FormBuilder, private router: Router) {
    this.PostusersForm = this.fb.group({
      firstname: [null, [Validators.required]],
      lastname: [null, [Validators.required]],
      username: [null, [Validators.required]],
      email: [null, [Validators.required]],
      password: [null, [Validators.required]],
    });
  }

  addUser() {
    if (this.PostusersForm.valid) {
      console.log(this.PostusersForm.value);
      this.userService.addUser(this.PostusersForm.value).subscribe((res) => {
        console.log(res);
        this.router.navigateByUrl("/users");
      });
    } else {
      console.log('Form is invalid. Please check the fields.');
    }
  }
}



