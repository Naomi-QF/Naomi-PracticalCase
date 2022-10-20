import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Course } from '../model/course.model';

@Injectable({
  providedIn: 'root'
})
export class CourseService {
  baseUrl:string ='http://localhost:9099/api/course';
  
  constructor(private httpClient: HttpClient) { }
  getCourses(){
    return this.httpClient.get<Course[]>(this.baseUrl);
  }

  createCourse(course:Course){
    console.log('start', course);

    return this.httpClient.post<Course>(this.baseUrl, course);   
  }

  deleteCourse(courseId:number){
    return this.httpClient.delete<Course>(`${this.baseUrl}/${courseId}`);
  }
}
