package com.main.app.exam_app.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.main.app.exam_app.entity.CourseQuestions;

public class CourseQuestionsDAOImpl implements CourseQuestionsDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public List<CourseQuestions> getCourseQuestions() {

		Session session = sessionFactory.getCurrentSession();
		List<CourseQuestions> question_list = session.createQuery("from CourseQuestions",CourseQuestions.class).list();
		return question_list;
		
	}

	@Override
	public CourseQuestions getCourseQuestion(int questionId) {

		Session session = sessionFactory.getCurrentSession();
		CourseQuestions question = session.get(CourseQuestions.class, questionId);
		return question;
		
	}

	@Override
	public void insertCourseQuestions(CourseQuestions coursequestion) {
		
		Session session = sessionFactory.getCurrentSession();
		session.save(coursequestion);

	}

	@Override
	public void updateCourseQuestions(int questionId, String questionName, String option1, String option2,
			String option3, String option4, int correct_option) {

		Session session = sessionFactory.getCurrentSession();
		CourseQuestions question_update = session.get(CourseQuestions.class, questionId);
		question_update.setQuestionName(questionName);
		question_update.setQuestionOption1(option1);
		question_update.setQuestionOption2(option2);
		question_update.setQuestionOption3(option3);
		question_update.setQuestionOption4(option4);
		question_update.setQuestionCorrectOption(correct_option);
		session.saveOrUpdate(question_update);

	}

	@Override
	public void deleteCourseQuestions(int questionId) {
		
		Session session = sessionFactory.getCurrentSession();
		CourseQuestions question_delete = session.get(CourseQuestions.class, questionId);
		session.delete(question_delete);
	}

}
