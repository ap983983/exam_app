package com.main.app.exam_app.dao;

import java.util.List;

import com.main.app.exam_app.entity.CourseQuestions;

public interface CourseQuestionsDAO {
	
	List<CourseQuestions> getCourseQuestions();
	CourseQuestions getCourseQuestion(int questionId);
	void updateOrInsertCourseQuestions(int courseId, CourseQuestions courseQuestion);
	void deleteCourseQuestions(int questionId);
}
