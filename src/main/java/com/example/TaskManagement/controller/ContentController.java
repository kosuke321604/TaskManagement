package com.example.TaskManagement.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.TaskManagement.entity.Content;
import com.example.TaskManagement.entity.User;
import com.example.TaskManagement.event.TaskInformEventPublisher;
import com.example.TaskManagement.form.ContentEditForm;
import com.example.TaskManagement.form.ContentRegisterForm;
import com.example.TaskManagement.repository.ContentRepository;
import com.example.TaskManagement.repository.UserRepository;
import com.example.TaskManagement.service.ContentService;

@Controller
@RequestMapping("/content")
public class ContentController {

private final UserRepository userRepository;
private final ContentRepository contentRepository;
private final ContentService contentService;
private final TaskInformEventPublisher taskInformEventPublisher;
    
  
    
    public ContentController(UserRepository userRepository,ContentRepository contentRepository,ContentService contentservice,TaskInformEventPublisher taskInformEventPublisher) {
        this.userRepository = userRepository; 
    	this.contentRepository = contentRepository;
        this.contentService = contentservice;
        this.taskInformEventPublisher = taskInformEventPublisher;
    }
    
    @GetMapping
    public String index(Model model) {
        List<Content> contents = contentRepository.findAll();       
        
        model.addAttribute("contents", contents);             
        
        return "content/index";
    }  
    
    @GetMapping("/{id}/edit")                  
    public String edit(@PathVariable(name = "id") Integer id, Model model) {
       Content content = contentRepository.getReferenceById(id);
       ContentEditForm contentEditForm = new ContentEditForm(content.getId(),content.getContent(),content.getMemo(),content.getDeadlineDate(),content.getDoneDate(),content.getMailFlag());
        
        model.addAttribute("contentEditForm",contentEditForm);
        
        return "content/edit";
    }    
    
    @GetMapping("/register")
    public String resigter(Model model) {
    	model.addAttribute("contentRegisterForm", new ContentRegisterForm());
    	
    	return "content/register";
    	
    }
    
    @PostMapping("/create")
    public String create(Model model,@ModelAttribute @Validated ContentRegisterForm contentRegisterForm, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
//    	if (bindingResult.hasErrors()) {
//            return "content/register";
//        }
    	contentService.create(contentRegisterForm);
    	redirectAttributes.addFlashAttribute("successMessage", "タスクを登録しました。");   
    	 List<Content> contents = contentRepository.findAll();          
         model.addAttribute("contents", contents);    
         
    	return "content/index";
    	
    }
    
    @PostMapping("/{id}/update")
    public String update(Model model,@ModelAttribute @Validated ContentEditForm contentEditForm) {
    	if(contentEditForm.getMailFlag()==1) {
    		contentService.updateMailFlag(contentEditForm);
    		User user = userRepository.findById(contentEditForm.getId()).orElse(new User());
    		Content updatedContent = contentService.updateMailFlag(contentEditForm);  
    		taskInformEventPublisher.publishTaskInformEvent(user, updatedContent);
    		
    		List<Content> contents = contentRepository.findAll();          
            model.addAttribute("contents", contents); 
    		
    		
    	}
    	contentService.update(contentEditForm);    	
    	List<Content> contents = contentRepository.findAll();          
        model.addAttribute("contents", contents); 
    	
    	return "content/index";
    }

	
    
  
    
    
    

}
