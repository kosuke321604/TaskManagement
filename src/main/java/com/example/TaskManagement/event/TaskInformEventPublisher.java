package com.example.TaskManagement.event;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import com.example.TaskManagement.entity.Content;
import com.example.TaskManagement.entity.User;

@Component
public class TaskInformEventPublisher {
	private final ApplicationEventPublisher applicationEventPublisher;
	
	public TaskInformEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
		this.applicationEventPublisher = applicationEventPublisher;
		
	}
	
	public void publishTaskInformEvent(User user,Content content) {
		applicationEventPublisher.publishEvent(new TaskInformEvent(this, user, content));
	}

}
