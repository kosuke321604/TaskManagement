package com.example.TaskManagement.event;

import org.springframework.context.ApplicationEvent;

import com.example.TaskManagement.entity.Content;
import com.example.TaskManagement.entity.User;

import lombok.Getter;

@Getter
public class TaskInformEvent extends ApplicationEvent {	
	private User user;
	private Content content;
	
	public TaskInformEvent(Object source,User user,Content content) {
		super(source);
		this.user = user;
		this.content = content;
		
	}
		

}
