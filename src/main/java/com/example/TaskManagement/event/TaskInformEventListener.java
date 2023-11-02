package com.example.TaskManagement.event;

import java.text.SimpleDateFormat;

import org.springframework.context.event.EventListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import com.example.TaskManagement.entity.Content;
import com.example.TaskManagement.entity.User;

@Component
public class TaskInformEventListener {
	private final JavaMailSender javaMailSender;
	
	public TaskInformEventListener(JavaMailSender mailSender) {
	    this.javaMailSender = mailSender;
		
	}
	
	@EventListener
	private void onTaskInformEvent(TaskInformEvent taskInformEvent) {
		User user = taskInformEvent.getUser();
		Content content = taskInformEvent.getContent();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
	 
		
		String recipientAddress = user.getEmail();
		String taskConetnt = content.getContent();
		String taskDeadline = sdf.format(content.getDeadlineDate());
		String subject = "タスク遅延リマインド";
		
		String message = "以下のタスクの期限が近づいています";
		
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setTo(recipientAddress);
		mailMessage.setSubject(subject);
		mailMessage.setText(message+"\n"+"タスク内容："+taskConetnt+"\n"+"タスク期限："+taskDeadline);
		javaMailSender.send(mailMessage);
		
		
		
	}

}
