import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { LoginService } from '../service/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  loginForm: FormGroup;

  constructor(private formBuilder:FormBuilder, private loginService:LoginService) { }

  ngOnInit(): void {

    this.loginForm = this.formBuilder.group({
      loginId:[],
      password:[]    
  })
}
  onSubmit() {
    this.loginService.getUsers().subscribe
    ((data)=> {
      console.log(data);
      
    })
  }}
