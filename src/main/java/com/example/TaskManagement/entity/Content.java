package com.example.TaskManagement.entity;

import java.sql.Date;
import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "task")
@Data
public class Content {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "user_id")
	private Integer userId;

	@Column(name = "content")
	private String content;
	
	@Column(name = "memo")
	private String memo;
	
	@Column(name = "deadline_date")
	private Date deadlineDate;
	
	@Column(name = "done_date")
	private Date doneDate;
	
	@Column(name = "mail_flag")
	private Integer mailFlag;
	
	@Column(name = "created_at", insertable = false, updatable = false)
    private Timestamp createdAt;

    @Column(name = "updated_at", insertable = false, updatable = false)
    private Timestamp updatedAt;
	
	
	
	
	

}