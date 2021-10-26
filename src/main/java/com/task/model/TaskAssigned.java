package com.task.model;

import java.util.Date;

import javax.persistence.*;

@Entity
public class TaskAssigned {

	//Task name
	@Id
	String task;
	
	//Email Id's of the people getting this task
	String[] emailId;
	
	//Time till assigned is to be completed
	Date date;

	public TaskAssigned() {}
	
	public TaskAssigned(String task, String[] emailId, Date date) {
		super();
		this.task = task;
		this.emailId = emailId;
		this.date = date;
	}

	public String getTask() {
		return task;
	}
	public void setTask(String task) {
		this.task = task;
	}
	public String[] getEmailId() {
		return emailId;
	}
	public void setEmailId(String[] emailId) {
		this.emailId = emailId;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}

	
}
