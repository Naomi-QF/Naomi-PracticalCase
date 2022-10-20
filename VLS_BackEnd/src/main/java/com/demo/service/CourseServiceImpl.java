package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entity.CourseEntity;
import com.demo.repository.CourseRepository;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	CourseRepository courseRepository;
	
	
	//Get courses catalogue
	@Override
	public List<CourseEntity> getCourses() {
		List<CourseEntity> courseCatalogue = courseRepository.findAll();
		return courseCatalogue;
	}

	// Add new course
	@Override
	public CourseEntity addCourse(CourseEntity courseEntity) {
		CourseEntity newCourse = courseRepository.save(courseEntity);
		return newCourse;
	}

	//Delete existing course
	@Override
	public CourseEntity deleteCourse(Integer courseId) {
		CourseEntity deletedCourse = courseRepository.findById(courseId).get();
		courseRepository.delete(deletedCourse);
		return deletedCourse;
	}

}
