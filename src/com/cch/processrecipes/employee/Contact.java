package com.cch.processrecipes.employee;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * @author Sagar Mali,Dada Gaikvad this test 
 *
 */

@Entity
@Table(name="employee_master")
public class Contact
{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="employee_master_sequence")
	@SequenceGenerator(name="employee_master_sequence", sequenceName="employee_master_sequence", allocationSize=1)
	private int id;
	@Column	private String first_name;
	@Column private String emp_skills; 
	@Column private String emp_email; 
 
	@Column private String last_name;

	public Contact()
	{
	}
	

	@Override
	public String toString()
	{
		return ToStringBuilder.reflectionToString(this);
	}
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}


	public Contact(int id, String first_name, String emp_skills, String emp_email, String last_name) {
		super();
		this.id = id;
		this.first_name = first_name;
		this.emp_skills = emp_skills;
		this.emp_email = emp_email;
		this.last_name = last_name;
	}


	public String getFirst_name() {
		return first_name;
	}


	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}


	public String getEmp_skills() {
		return emp_skills;
	}


	public void setEmp_skills(String emp_skills) {
		this.emp_skills = emp_skills;
	}


	public String getEmp_email() {
		return emp_email;
	}


	public void setEmp_email(String emp_email) {
		this.emp_email = emp_email;
	}


	public String getLast_name() {
		return last_name;
	}


	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

}
