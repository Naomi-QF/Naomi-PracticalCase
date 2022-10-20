import { Component, OnInit } from '@angular/core';
import { Course } from '../model/course.model';
import { CourseService } from '../service/course.service';

@Component({
  selector: 'app-course',
  templateUrl: './course.component.html',
  styleUrls: ['./course.component.css']
})
export class CourseComponent implements OnInit {
message='Courses list';
courses?:Course[];

  constructor(private courseService:CourseService) { }

  ngOnInit(): void {

    console.log("INIT... ");
    this.courseService.getCourses().subscribe(
      (data) =>{
        this.courses = data;
        console.log(this.courses);
      }
    )   
  }

  deleteCourse(deletedCourse : Course):void{
    console.log("Course deleted: ", deletedCourse);
    this.courseService.deleteCourse(deletedCourse.courseId).subscribe(
      (data)=>{
        this.courses= this.courses.filter(
          (course)=>{
            course!=deletedCourse;
          } )
          console.log('deleted', data);
          
      }
    )

  }

}
