package com.task.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.task.model.TaskAssigned;

@Service
public class TaskMailService {

	/*
	 * Abstraction provided by spring for sending email by using
	 * JavaMailSender interface
	 */
	private JavaMailSender javaMailSender;

	
	@Autowired
	public TaskMailService(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}

	public void sendEmail(TaskAssigned task) throws MailException {

		/*
		 * Fetching the mail IDs of all users whom the task is to be assigned
		 */
		String [] userMailIds;
		userMailIds = task.getEmailId();
		
		/*
		 * JavaMailSender extends the MailSender Interface which contains send()
		 * function. SimpleMailMessage Object is required because send() function uses
		 * object of SimpleMailMessage as a Parameter
		 */
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(userMailIds);
		mail.setSubject("Task given to you is: "+userMailIds);
		mail.setText("Complete the task on or before: "+task.getDate());

		/*
		 * This send() contains an Object of SimpleMailMessage as an Parameter
		 */
		javaMailSender.send(mail);
		System.out.println("Mail sent successfully.....");
	}
	
}
