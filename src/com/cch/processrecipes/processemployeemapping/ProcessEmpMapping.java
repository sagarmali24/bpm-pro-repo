package com.cch.processrecipes.processemployeemapping;

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
@Table(name="process_employee_mapping")
public class ProcessEmpMapping
{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="process_employee_mapping_sequence")
	@SequenceGenerator(name="process_employee_mapping_sequence", sequenceName="process_employee_mapping_sequence", allocationSize=1)
	private int id;
	@Column	private int emp_id;
	@Column private int  process_id; 
	
 
	

	public ProcessEmpMapping()
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


	public ProcessEmpMapping(int id, int emp_id, int process_id) {
		super();
		this.id = id;
		this.emp_id = emp_id;
		this.process_id = process_id;
	}


	public int getEmp_id() {
		return emp_id;
	}


	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}


	public int getProcess_id() {
		return process_id;
	}


	public void setProcess_id(int process_id) {
		this.process_id = process_id;
	}


	
}
