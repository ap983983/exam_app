package com.main.app.exam_app.dao;

import java.util.List;

import com.main.app.exam_app.entity.CourseQuestions;

public interface CourseQuestionsDAO {
	
	List<CourseQuestions> getCourseQuestions();
	CourseQuestions getCourseQuestion(int questionId);
	void insertCourseQuestions(CourseQuestions coursequestion);
	void updateCourseQuestions(int questionId,String questionName,String option1, String option2, String option3, String option4, int correct_option);
	void deleteCourseQuestions(int questionId);
}
