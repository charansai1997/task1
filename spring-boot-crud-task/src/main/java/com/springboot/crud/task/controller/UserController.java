package com.springboot.crud.task.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.crud.task.entity.User;
import com.springboot.crud.task.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService service;

	@PostMapping("/addUser")
	public User addUser(@Valid @RequestBody User user) {
		return service.saveUser(user);
	}

	@PostMapping("/addUsers")
	public List<User> addUser(@Valid @RequestBody List<User> users) {
		return service.saveUsers(users);
	}

	@GetMapping("/users")
	public List<User> findAllUsers() {
		return service.getUsers();
	}

	@GetMapping("/userById/{id}")
	public User findUserById(@PathVariable int id) { 
		return service.getUserById(id);
	}

	@GetMapping("/userByName/{name}")
	public List<User> findUserByName(@PathVariable String name) {
		return service.getUserByName(name);
	}

	@GetMapping("/userBySurName/{surName}")
	public List<User> findUserBySurName(@PathVariable String surName) {
		return service.getUserBySurName(surName);
	}

	@GetMapping("/userByPincode/{pincode}")
	public List<User> findUserByPincode(@PathVariable String pincode) {
		return service.getUserByPincode(pincode);
	}
	@GetMapping("/sortByDob")
	public List<User> sortUserByDob(){
		return service.sortByDob();
	}
	@GetMapping("/sortByJoiningDate")
	public List<User> sortUserByJoiningDate(){
		return service.sortByJoiningDate();
	}
	@PutMapping("/update")
	public User updateUser(@RequestBody User user) {
		return service.updateUser(user);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteUser(@PathVariable int id) {
		return service.deleteUser(id);
	}
}
