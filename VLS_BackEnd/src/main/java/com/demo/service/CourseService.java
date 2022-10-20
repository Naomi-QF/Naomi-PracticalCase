package com.demo.service;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;

import com.demo.entity.CourseEntity;

public interface CourseService {
	
	public List<CourseEntity> getCourses();
	
	public CourseEntity addCourse(CourseEntity courseEntity);
	
	public CourseEntity deleteCourse(@PathVariable(value="courseId") Integer courseId);
	
}
