package com.main.app.exam_app.dao;

import java.util.List;
import javax.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.main.app.exam_app.entity.Courses;

@Repository
public class CoursesDAOImpl implements CoursesDAO {


	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional
	public List<Courses> getCourses() {
		
		Session session = sessionFactory.getCurrentSession();
		List<Courses> course_list = session.createQuery("from Courses",Courses.class).list();
		return course_list;
		
	}

	@Transactional
	public Courses getCourse(int courseId) {

		Session session = sessionFactory.getCurrentSession();
		Courses course = session.get(Courses.class, courseId);
		return course;
	}

	@Transactional
	public void insertCourses(Courses course) {

		Session session = sessionFactory.getCurrentSession();
		session.save(course);
		
	}

	@Transactional
	public void updateCourse(int courseId, String courseName) {

		Session session = sessionFactory.getCurrentSession();
		Courses course_update = session.get(Courses.class, courseId);
		course_update.setCourseName(courseName);
		session.saveOrUpdate(course_update);

	}

	@Transactional
	public void deleteCourse(int courseId) {

		Session session = sessionFactory.getCurrentSession();
		Courses course_delete = session.get(Courses.class, courseId);
		session.delete(course_delete);
	}


}
