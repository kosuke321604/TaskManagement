package com.example.TaskManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.TaskManagement.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

}