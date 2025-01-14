package model;

import java.util.UUID;

import jakarta.persistence.*;

@Entity
@Table(name="Department")
public class Department {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private UUID id;
	@Column(name="departmnent_name")
	private String departmentName;
	@Column(name="department_code")
	private String departmentCode;
	
	public Department() {
	}

	public Department(UUID id, String departmentName, String departmentCode) {
		this.id = id;
		this.departmentName = departmentName;
		this.departmentCode = departmentCode;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getDepartmentCode() {
		return departmentCode;
	}

	public void setDepartmentCode(String departmentCode) {
		this.departmentCode = departmentCode;
	}
	
	

}
