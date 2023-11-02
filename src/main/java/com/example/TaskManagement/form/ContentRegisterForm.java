package com.example.TaskManagement.form;

import lombok.Data;

@Data
public class ContentRegisterForm {
	private String content;
	
	private String memo;
	
	private String deadlineDate;
	
	private String doneDate;
	
	private int mailFlag;
	

}
