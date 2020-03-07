package com.main.app.exam_app.controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.main.app.exam_app.dao.CourseQuestionsDAO;
import com.main.app.exam_app.dao.CourseSectionDAO;
import com.main.app.exam_app.dao.CoursesDAO;
import com.main.app.exam_app.entity.CourseQuestions;
import com.main.app.exam_app.entity.CourseSections;
import com.main.app.exam_app.entity.Courses;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	CourseSectionDAO courseSection;
	
	@Autowired
	CoursesDAO courseDAO;
	
	@Autowired
	CourseQuestionsDAO courseQuestionDAO;
	
	@GetMapping("/")
	public ModelAndView adminHome(ModelAndView model_view) {
		
		Map<String,List<Courses>> course_chart = new HashMap<>();
		List<CourseSections> section_list = courseSection.getCourseSections();
		Iterator<CourseSections> itr = section_list.iterator();
		while(itr.hasNext()) {
			CourseSections coursesections = (CourseSections) itr.next();
			course_chart.put(coursesections.getSectionName(), coursesections.getCourses());
		}
		model_view.addObject("course_chart", course_chart);
		model_view.setViewName("admin/dashboard");
		return model_view;
	}
	
	@GetMapping("/courseQuestions")
	public ModelAndView courseQuestions(@RequestParam("course_id") int courseId, ModelAndView model_view) {
	
		Courses course = courseDAO.getCourse(courseId);
		model_view.addObject("questions_list", course.getCourseQuestions());
		model_view.addObject("course_id",courseId);
		model_view.setViewName("admin/question_list");
		return model_view;
		
	}
	
	@GetMapping("/showUpdateForm")	
	public ModelAndView showQuestionForm(@RequestParam("course_id") int courseId,
										 @RequestParam("questionId") int questionId, 
										 ModelAndView model_view) {
		
		CourseQuestions courseQuestion = courseQuestionDAO.getCourseQuestion(questionId);
		model_view.addObject("question", courseQuestion);
		model_view.addObject("course_id",courseId);
		model_view.setViewName("admin/questionform");
		return model_view;
	
	}
	
	@PostMapping("/updateQuestion")
	public ModelAndView updateQuestion(@RequestParam("course_id") int courseId,
									   @ModelAttribute("question") CourseQuestions question, 
									   ModelAndView model_view) {
		
		courseQuestionDAO.updateOrInsertCourseQuestions(courseId, question);
		model_view.setViewName("redirect:courseQuestions?course_id=" + courseId);
		return model_view;
		
	}
	
	@GetMapping("/deleteQuestion")
	public ModelAndView deleteQuestion(@RequestParam("course_id") int courseId,
									   @RequestParam("questionId") int questionId, ModelAndView model_view) {
		
		courseQuestionDAO.deleteCourseQuestions(questionId);
		model_view.addObject("course_id",courseId);
		model_view.setViewName("redirect:courseQuestions");
		return model_view;
		
	}
	
	@GetMapping("/showInsertForm")
	public ModelAndView showQuestionForm(@RequestParam("course_id") int courseId, ModelAndView model_view) {
		
		CourseQuestions question_form = new CourseQuestions();
		model_view.addObject("question",question_form);
		model_view.addObject("course_id",courseId);
		model_view.setViewName("admin/questionform");
		return model_view;
	}
	
}
