package com.main.app.exam_app.dao;

import java.util.List;
import javax.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.main.app.exam_app.entity.CourseQuestions;
import com.main.app.exam_app.entity.Courses;

@Repository
public class CourseQuestionsDAOImpl implements CourseQuestionsDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional
	public List<CourseQuestions> getCourseQuestions() {

		Session session = sessionFactory.getCurrentSession();
		List<CourseQuestions> question_list = session.createQuery("from CourseQuestions",CourseQuestions.class).list();
		return question_list;
		
	}

	@Transactional
	public CourseQuestions getCourseQuestion(int questionId) {

		Session session = sessionFactory.getCurrentSession();
		CourseQuestions question = session.get(CourseQuestions.class, questionId);
		return question;
		
	}

	@Transactional
	public void updateOrInsertCourseQuestions(int courseId,CourseQuestions courseQuestion) {
		
		Session session = sessionFactory.getCurrentSession();
		Courses course = session.get(Courses.class, courseId);
		course.add(courseQuestion);
		session.saveOrUpdate(courseQuestion);

	}

	@Transactional
	public void deleteCourseQuestions(int questionId) {
		
		Session session = sessionFactory.getCurrentSession();
		CourseQuestions question_delete = session.get(CourseQuestions.class, questionId);
		session.delete(question_delete);
	}

}
