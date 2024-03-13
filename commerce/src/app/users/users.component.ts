import { Component } from '@angular/core';
import { UsersService } from '../users.service'
@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrl: './users.component.css'
})
export class UsersComponent {
  usersLists: any[] = [];




  constructor(private service: UsersService) { }

  ngOnInit() {
    this.getAllUsers();
  }


  getAllUsers() {
    this.service.getAllUsers().subscribe((res) => {
      this.usersLists = res;
    });
  }

  deleteUser(id: number) {
    this.service.deleteUser(id).subscribe(() => {
      this.getAllUsers();
    });
  }

}
