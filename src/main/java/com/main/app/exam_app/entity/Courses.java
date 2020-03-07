package com.main.app.exam_app.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="courses")
public class Courses {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="course_id")
	private Integer courseId;
	
	@Column(name="course_name")
	private String courseName;

	//Mapping with course section table
	@ManyToOne(cascade= {CascadeType.DETACH,
			  CascadeType.MERGE,
			  CascadeType.PERSIST,
			  CascadeType.REFRESH})
	@JoinColumn(name="section_id")
	private CourseSections courseSection;
	
	
	//Mapping with course questions table
	@OneToMany(mappedBy="course",cascade= {CascadeType.DETACH,
										   CascadeType.MERGE,
										   CascadeType.PERSIST,
										   CascadeType.REFRESH})
	private List<CourseQuestions> courseQuestions;
	
	
	public Courses() {

	}
	
	public Courses(String courseName) {
		this.courseName = courseName;
	}

	public Integer getCourseId() {
		return courseId;
	}

	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public List<CourseQuestions> getCourseQuestions() {
		return courseQuestions;
	}

	public void setCourseQuestions(List<CourseQuestions> courseQuestions) {
		this.courseQuestions = courseQuestions;
	}
	
	public void add(CourseQuestions tempQuestion) {
		
		if(tempQuestion == null)
			courseQuestions = new ArrayList<>();
		courseQuestions.add(tempQuestion);
		tempQuestion.setCourse(this);
	}
	

}
