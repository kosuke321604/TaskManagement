package com.example.TaskManagement.form;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ContentEditForm {
	private Integer id; 
    
	private String content;
	
	private String memo;
	
	private Date deadlineDate;
	
	private Date doneDate;
	
	private int mailFlag;

}
