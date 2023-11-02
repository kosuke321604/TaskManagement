package com.example.TaskManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.TaskManagement.entity.Content;

public interface ContentRepository extends JpaRepository<Content, Integer> {

}