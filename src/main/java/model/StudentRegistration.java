package model;

import java.util.*;

import jakarta.persistence.*;

@Entity
@Table(name="StudentRegistration")
public class StudentRegistration {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private UUID ID;
	@Column(name="registration_date")
	private Date registrationDate;
	@Column(name="registration_number")
	private int registrationNumber;
	
	@ManyToOne
	@JoinColumn(name="semester_id", nullable=false)
	private Semester semester;
	
	@ManyToOne
	@JoinColumn(name="student_id", nullable=false)
	private Student student;
	
	@ManyToOne
	@JoinColumn(name="department_id", nullable=false)
	private Department department;

	public UUID getID() {
		return ID;
	}

	public void setID(UUID iD) {
		ID = iD;
	}

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	public int getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(int registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public Semester getSemester() {
		return semester;
	}

	public void setSemester(Semester semester) {
		this.semester = semester;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

}