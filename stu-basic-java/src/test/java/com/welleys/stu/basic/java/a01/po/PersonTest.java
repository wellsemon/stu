package com.welleys.stu.basic.java.a01.po;

import static org.junit.Assert.assertEquals;

import java.util.logging.Logger;

import org.junit.Before;
import org.junit.Test;

import com.welleys.stu.basic.java.a01.po.Person;

public class PersonTest {
	private static Logger log = Logger.getLogger(PersonTest.class.getName());
	
	private Person person;
	
	@Before
	public void init() {
		person = new Person("zhang", "san", 22, 173, 83, "Blue", "MALE");
	}

	@Test
	public void testPerson() {	
		log.info("Name: " + person.getFirstName());
		
		assertEquals("zhang", person.getFirstName());
	}

	@Test
	public void testToString() {		
		log.info("toString(): " + person.toString());
		
		assertEquals("Person [firstName=zhang, lastName=san, age=22, height=173, weight=83, eyeColor=Blue, gender=MALE]", person.toString());
	}
	
	@Test
	public void testFullName() {
		assertEquals("zhang san", person.getFullName());
	}
}
