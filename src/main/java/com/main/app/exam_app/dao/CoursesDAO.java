package com.main.app.exam_app.dao;

import java.util.List;

import com.main.app.exam_app.entity.Courses;

public interface CoursesDAO {

	List<Courses> getCourses();
	Courses getCourse(int courseId);
	void insertCourses(Courses course);
	void updateCourse(int courseId,String courseName);
	void deleteCourse(int courseId);
}
