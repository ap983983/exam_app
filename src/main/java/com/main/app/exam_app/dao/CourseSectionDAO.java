package com.main.app.exam_app.dao;

import java.util.List;
import com.main.app.exam_app.entity.CourseSections;
import com.main.app.exam_app.entity.Courses;

public interface CourseSectionDAO {
	
	List<CourseSections> getCourseSections();
	CourseSections getCourseSection(int section_id);
	void insertCourseSection(CourseSections courseSections);
	void updateCourseSection(int section_id,String section_name);
	void deleteCourseSection(int section_id);

}
