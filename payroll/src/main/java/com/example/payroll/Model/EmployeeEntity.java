package com.example.payroll.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employees")
public class EmployeeEntity {

	private @Id @GeneratedValue(strategy=GenerationType.IDENTITY) Long id;
	private String firstName;
	private String lastName;
	private String role;
	
	EmployeeEntity() {}

	EmployeeEntity(String firstName, String lastName, String role) {
		
	    this.firstName = firstName;
	    this.lastName = lastName;
	    this.role = role;
	}  
	public Long getId() {
	    return this.id;
	}
	
	public void setId(Long id) {
	    this.id = id;
	}
	
	public String getfirstName() {
		return firstName;
	}
	
	public void setfirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getlastName() {
		return lastName;
	}
	
	public void setlastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getRole() {
	    return this.role;
	}
	
	public void setRole(String role) {
	    this.role = role;
	} 
	
//	@Override
//	  public boolean equals(Object o) {
//
//	    if (this == o)
//	      return true;
//	    if (!(o instanceof EmployeeEntity))
//	      return false;
//	    EmployeeEntity employee = (EmployeeEntity) o;
//	    return Objects.equals(this.id, employee.id) && Objects.equals(this.name, employee.name)
//	        && Objects.equals(this.role, employee.role);
//	  }
//
//	  @Override
//	  public int hashCode() {
//	    return Objects.hash(this.id, this.name, this.role);
//	  }
//
//	  @Override
//	  public String toString() {
//	    return "Employee{" + "id=" + this.id + ", name='" + this.name + '\'' + ", role='" + this.role + '\'' + '}';
//	  }
}
