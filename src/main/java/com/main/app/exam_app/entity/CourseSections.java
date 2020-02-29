package com.main.app.exam_app.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="course_section")
public class CourseSections {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="section_id")
	private Integer sectionId;
	
	@Column(name="section_name")
	private String sectionName;
	
	@OneToMany(mappedBy="courseSection",cascade= {CascadeType.DETACH,
												  CascadeType.MERGE,
												  CascadeType.PERSIST,
												  CascadeType.REFRESH},
				fetch=FetchType.LAZY)
	private List<Courses> courses;

	
	public CourseSections() {
		
	}
	
	public CourseSections(String sectionName) {
		this.sectionName = sectionName;
	}

	public Integer getSectionId() {
		return sectionId;
	}

	public void setSectionId(Integer sectionId) {
		this.sectionId = sectionId;
	}

	public String getSectionName() {
		return sectionName;
	}

	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}

	public List<Courses> getCourses() {
		return courses;
	}

	public void setCourses(List<Courses> courses) {
		this.courses = courses;
	}
	
	
	
}
