package model;
import java.util.*;
import jakarta.persistence.*;
@Entity
@Table(name="Semester")
public class Semester {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private UUID id;
	@Column(name = "semester_name")
	private String semesterName;
	@Column(name="start_date")
	private Date startDate;
	@Column(name="end_date")
	private Date endDate;
	public Semester() {
	}
	public Semester(UUID id, String semesterName, Date startDate, Date endDate) {
		this.id = id;
		this.semesterName = semesterName;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public String getSemesterName() {
		return semesterName;
	}
	public void setSemesterName(String semesterName) {
		this.semesterName = semesterName;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	
}
