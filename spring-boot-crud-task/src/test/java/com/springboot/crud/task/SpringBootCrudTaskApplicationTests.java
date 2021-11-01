package com.springboot.crud.task;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.springboot.crud.task.entity.User;
import com.springboot.crud.task.repository.UserRepository;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class SpringBootCrudTaskApplicationTests {

	@Autowired
	private UserRepository uRepository;
	
	@Test
	@Order(1)
	public void testCreate() {
		User u = new User(1,"kalyan","nandaluri","1997-01-15","2021-08-26","AP","516269");
		uRepository.save(u);
		assertNotNull(uRepository.findById(1).get());
	}
	@Test
	@Order(2)
	public void testReadAll() {
		List<User> list = uRepository.findAll();
		assertThat(list).size().isGreaterThan(0);
	}
	@Test
	@Order(3)
	public void testSingleUser() {
		User user = uRepository.findById(1).get();
		assertEquals("516269", user.getPincode());
	}
	@Test
	@Order(4)
	public void testUpdate() {
		User u = uRepository.findById(1).get();
		u.setName("Pavan Kalyan");
		uRepository.save(u);
		assertNotEquals("kalyan", uRepository.findById(1).get().getName());
	}
	
	@Test
	@Order(5)
	public void testDelete() {
		uRepository.deleteById(1);
		assertThat(uRepository.existsById(1)).isFalse();
	}
	
	
	
	
	
	
	
	

}
