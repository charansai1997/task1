package com.springboot.crud.task.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.springboot.crud.task.entity.User;
import com.springboot.crud.task.repository.UserRepository;

@Service
public class UserService  {

	@Autowired
	private UserRepository repository;

	// POST Method to save single user
	public User saveUser(User user) {
		return repository.save(user);
	}

	// POST Method to save list of Users
	public List<User> saveUsers(List<User> users) {
		return repository.saveAll(users);
	}

	// GET Method to fetch all users from Database
	public List<User> getUsers() {
		return repository.findAll();
	}

	// GET Method to search user by Id
	public User getUserById(int id) {
		Optional<User> user = repository.findById(id);
		if (user.isPresent()) {
			return user.get();
		}
		throw new RuntimeException("User is not found for the id : " + id);
	}

	// GET Method to search user by Name
	public List<User> getUserByName(String name) {
		return repository.findByName(name);
	}

	// GET Method to search user by SurName
	public List<User> getUserBySurName(String surName) {
		return repository.findBySurName(surName);
	}

	// GET Method to search user by Pin code
	public List<User> getUserByPincode(String pincode) {
		return repository.findByPincode(pincode);
	}
	// GET Method to sort user by Dob
	public List<User> sortByDob(){
		return repository.findAll(Sort.by("dob").descending());
	}
	public List<User> sortByJoiningDate(){
		return repository.findAll(Sort.by("joiningDate").descending());
	}

	// DELETE Method to delete user by Id
	public String deleteUser(int id) {
		repository.deleteById(id);
		return "User removed !! " + id;
	}

	// PUT Method id to update
	public User updateUser(User user) {
		User existingUser = repository.findById(user.getId()).orElse(null);
		existingUser.setName(user.getName());
		existingUser.setSurName(user.getSurName());
		existingUser.setDob(user.getDob());
		existingUser.setJoiningDate(user.getJoiningDate());
		existingUser.setState(user.getState());
		existingUser.setPincode(user.getPincode());
		return repository.save(existingUser);

	}
}
