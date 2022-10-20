package com.demo.entity;

import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="COURSE")
public class CourseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="COURSE_ID")
	private int courseId;
	
	@Column(name="COURSE_NAME")
	private String courseName;
	
	@Column(name="AUTHOR_NAME")
	private String authorName;
	
	@Column(name="DURATION")
	private Time duration;
	
	@Column(name="AVAILABILITY")
	private int availability;

	//Constructor
	public CourseEntity() {
		
	}

	//Getters and setters
	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public Time getDuration() {
		return duration;
	}

	public void setDuration(Time duration) {
		this.duration = duration;
	}

	public int getAvailability() {
		return availability;
	}

	public void setAvailability(int availability) {
		this.availability = availability;
	}

	//To string method
	@Override
	public String toString() {
		return "CourseEntity [courseId=" + courseId + ", courseName=" + courseName + ", authorName=" + authorName
				+ ", duration=" + duration + ", availability=" + availability + "]";
	}
	
	
	
}
