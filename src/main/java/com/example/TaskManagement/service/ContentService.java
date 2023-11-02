package com.example.TaskManagement.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.TaskManagement.entity.Content;
import com.example.TaskManagement.form.ContentEditForm;
import com.example.TaskManagement.form.ContentRegisterForm;
import com.example.TaskManagement.repository.ContentRepository;

@Service
public class ContentService {
private final ContentRepository contentRepository;         
    
    public ContentService(ContentRepository contentRepository) {
        this.contentRepository = contentRepository;                
    }	

    @Transactional
    public void create(ContentRegisterForm contentRegisterForm) {
    	Content content = new Content();
    	content.setUserId(1);// TODO ログインユーザを設定する想定
    	content.setContent(contentRegisterForm.getContent());
    	content.setMemo(contentRegisterForm.getMemo());
    	content.setDeadlineDate(java.sql.Date.valueOf(contentRegisterForm.getDeadlineDate()));
    	content.setDoneDate(java.sql.Date.valueOf(contentRegisterForm.getDoneDate()));
    	content.setMailFlag(contentRegisterForm.getMailFlag());
    	    	
    	contentRepository.save(content);
    	
    }
    
    @Transactional
    public void update(ContentEditForm contentEditForm) {
    	Content content = contentRepository.getReferenceById(contentEditForm.getId());
    	
    	content.setContent(contentEditForm.getContent());
    	content.setMemo(contentEditForm.getMemo());
    	content.setDeadlineDate(contentEditForm.getDeadlineDate());
    	content.setDoneDate(contentEditForm.getDoneDate());
    	content.setMailFlag(contentEditForm.getMailFlag());
    	
    	contentRepository.save(content);
    	
    }
    
    @Transactional
    public Content updateMailFlag(ContentEditForm contentEditForm) {
    	Content content = contentRepository.getReferenceById(contentEditForm.getId());
    	
    	content.setContent(contentEditForm.getContent());
    	content.setMemo(contentEditForm.getMemo());
    	content.setDeadlineDate(contentEditForm.getDeadlineDate());
    	content.setDoneDate(contentEditForm.getDoneDate());
    	content.setMailFlag(contentEditForm.getMailFlag());
    	
    	return contentRepository.save(content);
    	
    }
}
