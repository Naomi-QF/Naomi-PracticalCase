import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Course } from '../model/course.model';
import { CourseService } from '../service/course.service';

@Component({
  selector: 'app-add-course',
  templateUrl: './add-course.component.html',
  styleUrls: ['./add-course.component.css']
})
export class AddCourseComponent implements OnInit {
courses?: Course[];
addCourseForm?:FormGroup;
alertTime?:any;


  constructor(private formBuilder:FormBuilder, private courseService: CourseService) { }

  ngOnInit(): void {

    this.addCourseForm=this.formBuilder.group({
      courseId:[],
      courseName:[],
      authorName:[],
      duration:[],
      availability:[]
    })
  }

  //method to add a new course
  addCourse(){
    this.courseService.createCourse(this.addCourseForm.value).subscribe
    ((data)=>{
      console.log('saved', data);

    })
  }
}
