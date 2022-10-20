package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.entity.CourseEntity;
import com.demo.service.CourseService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CourseController {
	
	@Autowired
	CourseService courseService;
	
	@GetMapping("/api/course")
	public List<CourseEntity> getCourse(){
		List<CourseEntity> courseList = courseService.getCourses();
		return courseList;
	}
	
	@PostMapping("/api/course")
	public CourseEntity addCourse(@RequestBody CourseEntity courseEntity) {
		CourseEntity addedCourse = courseService.addCourse(courseEntity);
		
		return addedCourse;
	}
	
	@DeleteMapping("/api/course/{courseId}")
	public CourseEntity deleteCourse(@PathVariable(value="courseId") Integer courseId) {
		CourseEntity deletedCourse = courseService.deleteCourse(courseId);
		return deletedCourse;
	}
	

}
