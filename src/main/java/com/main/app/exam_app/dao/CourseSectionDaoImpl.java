package com.main.app.exam_app.dao;

import java.util.List;
import javax.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.main.app.exam_app.entity.CourseSections;

@Repository
public class CourseSectionDaoImpl implements CourseSectionDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	public List<CourseSections> getCourseSections() {
		Session session = sessionFactory.getCurrentSession();
		List<CourseSections> course_sections_list=session.createQuery("from CourseSections",CourseSections.class).list();
		return course_sections_list;
	}

	@Transactional
	public CourseSections getCourseSection(int section_id) {
		
		Session session = sessionFactory.getCurrentSession();
		CourseSections section = session.get(CourseSections.class,section_id);
		return section;
		
	}

	@Transactional
	public void insertCourseSection(CourseSections courseSections) {
		
		Session session = sessionFactory.getCurrentSession();
		session.save(courseSections);
		
	}

	@Transactional
	public void updateCourseSection(int section_id,String section_name) {
		
		Session session = sessionFactory.getCurrentSession();
		CourseSections section_update = session.get(CourseSections.class, section_id);
		section_update.setSectionName(section_name);
		session.saveOrUpdate(section_update);
		
	}

	@Transactional
	public void deleteCourseSection(int section_id) {

		Session session = sessionFactory.getCurrentSession();
		CourseSections section_delete = session.get(CourseSections.class, section_id);
		session.delete(section_delete);
		
	}


	
	
}
