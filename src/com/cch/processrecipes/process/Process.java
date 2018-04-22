package com.cch.processrecipes.process;

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
@Table(name="process_master")
public class Process
{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="process_master_sequence")
	@SequenceGenerator(name="process_master_sequence", sequenceName="process_master_sequence", allocationSize=1)
	private int id;
	@Column	private String process_name;
	@Column private String process_desc; 
	
 
	

	public Process()
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


	public Process(int id, String process_name, String process_desc) {
		super();
		this.id = id;
		this.process_name = process_name;
		this.process_desc = process_desc;
	}


	public String getProcess_name() {
		return process_name;
	}


	public void setProcess_name(String process_name) {
		this.process_name = process_name;
	}


	public String getProcess_desc() {
		return process_desc;
	}


	public void setProcess_desc(String process_desc) {
		this.process_desc = process_desc;
	}


	

	

}
