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
import com.main.app.exam_app.dao.CourseSectionDAO;
import com.main.app.exam_app.dao.CoursesDAO;
import com.main.app.exam_app.entity.CourseQuestionList;
import com.main.app.exam_app.entity.CourseQuestions;
import com.main.app.exam_app.entity.CourseSections;
import com.main.app.exam_app.entity.Courses;

@Controller
@RequestMapping("/users")
public class AppController {

	@Autowired
	CourseSectionDAO courseSectionDAO;
	
	@Autowired
	CoursesDAO courseDAO;
	
	@GetMapping(path="/")
	public String homePage() {
		return "index";
	}
	
	@GetMapping(path="/dashboard")
	public ModelAndView dashboard(ModelAndView model) {
		Map<String,List<Courses>> course_chart = new HashMap<>(); 
		List<CourseSections> course_section_list = courseSectionDAO.getCourseSections();
		Iterator<CourseSections> itr = course_section_list.iterator();
		while(itr.hasNext()) {
			CourseSections coursesections = (CourseSections) itr.next();
			course_chart.put(coursesections.getSectionName(), coursesections.getCourses());
		}
		
		for (Map.Entry itr1 : course_chart.entrySet()) {
			System.out.print(itr1.getKey());
			System.out.println(itr1.getValue());
		}
		model.addObject("course_chart", course_chart);
		model.setViewName("user/dashboard");
		return model;
	}
	
	@GetMapping("/courses")
	public ModelAndView courseQuestions(@RequestParam("course_id") Integer courseId,ModelAndView model_view) {
		Courses course = courseDAO.getCourse(courseId);
		System.out.println(course.getCourseQuestions());
		List<CourseQuestions> questions = course.getCourseQuestions();
		CourseQuestionList questionsList = new CourseQuestionList();
		questionsList.setCourseQuestion(questions);
		model_view.addObject("course_question_list", questionsList);
		model_view.setViewName("user/course_questions");
		return model_view;
	}
	
	@PostMapping("/results")
	public ModelAndView examResult(@ModelAttribute("course_question_list") CourseQuestionList questionList, ModelAndView model_view) {
		int result = 0;
		List<CourseQuestions> list = questionList.getCourseQuestion();
		for(int i=0;i<list.size();i++) {
			CourseQuestions q = list.get(i);
//			System.out.print(q.getQuestionId() + " " + q.getQuestionName() + " " + q.getQuestionOption1()+ " "+
//							q.getQuestionOption2()+ " "+q.getQuestionOption3() + " " + q.getQuestionOption4()+" " +
//						q.getQuestionCorrectOption());
			if(q.getQuestionOption1() != null && Integer.parseInt(q.getQuestionOption1()) == q.getQuestionCorrectOption()) {
				result++;
			}else if(q.getQuestionOption2() != null && Integer.parseInt(q.getQuestionOption2()) == q.getQuestionCorrectOption()) {
				result++;
			}else if(q.getQuestionOption3() != null && Integer.parseInt(q.getQuestionOption3()) == q.getQuestionCorrectOption()) {
				result++;
			}else if(q.getQuestionOption4() != null && Integer.parseInt(q.getQuestionOption4()) == q.getQuestionCorrectOption()) {
				result++;
			}
		}
		model_view.addObject("selectedoptions",questionList);
		model_view.addObject("result", result);
		model_view.setViewName("user/results");
		return model_view; 
	}
	
}

