package model;

import java.util.*;

import jakarta.persistence.*;

@Entity
@Table(name="StudentCourses")
public class StudentCourses {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private UUID id;
	@Column(name="marks_in_course")
	private int marksInCourse;
	@ManyToOne
	@JoinColumn(name="student_id", nullable=false)
	private Student student;
	@ManyToOne
	@JoinColumn(name="course_code", nullable=false)
	private Course course;
	
	public StudentCourses() {
	}

	public StudentCourses(UUID id, int marksInCourse, Student student, Course course) {
		this.id = id;
		this.marksInCourse = marksInCourse;
		this.student = student;
		this.course = course;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public int getMarksInCourse() {
		return marksInCourse;
	}

	public void setMarksInCourse(int marksInCourse) {
		this.marksInCourse = marksInCourse;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}
	
	
	
	

}
