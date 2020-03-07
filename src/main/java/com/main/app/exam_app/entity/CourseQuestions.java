package com.main.app.exam_app.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="course_questions")
public class CourseQuestions {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="question_id")
	private Integer questionId;
	
	@Column(name="question_name")
	private String questionName;
	
	@Column(name="question_o_1")
	private String questionOption1;
	
	@Column(name="question_o_2")
	private String questionOption2;
	
	@Column(name="question_o_3")
	private String questionOption3;
	
	@Column(name="question_o_4")
	private String questionOption4;
	
	@Column(name="question_oc_no")
	private Integer questionCorrectOption;
	
	@ManyToOne(cascade= {CascadeType.DETACH,
			   CascadeType.MERGE,
			   CascadeType.PERSIST,
			   CascadeType.REFRESH})
	@JoinColumn(name="course_id",nullable=false,updatable=false)
	private Courses course;

	public CourseQuestions() {

	}
	
	public Integer getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Integer questionId) {
		this.questionId = questionId;
	}

	public String getQuestionName() {
		return questionName;
	}

	public void setQuestionName(String questionName) {
		this.questionName = questionName;
	}

	public String getQuestionOption1() {
		return questionOption1;
	}

	public void setQuestionOption1(String questionOption1) {
		this.questionOption1 = questionOption1;
	}

	public String getQuestionOption2() {
		return questionOption2;
	}

	public void setQuestionOption2(String questionOption2) {
		this.questionOption2 = questionOption2;
	}

	public String getQuestionOption3() {
		return questionOption3;
	}

	public void setQuestionOption3(String questionOption3) {
		this.questionOption3 = questionOption3;
	}

	public String getQuestionOption4() {
		return questionOption4;
	}

	public void setQuestionOption4(String questionOption4) {
		this.questionOption4 = questionOption4;
	}

	public Integer getQuestionCorrectOption() {
		return questionCorrectOption;
	}

	public void setQuestionCorrectOption(Integer questionCorrectOption) {
		this.questionCorrectOption = questionCorrectOption;
	}

	public Courses getCourse() {
		return course;
	}

	public void setCourse(Courses course) {
		this.course = course;
	}
	
	

}
