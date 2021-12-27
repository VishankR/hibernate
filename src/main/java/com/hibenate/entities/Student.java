package com.hibenate.entities;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

import hibernate.entities.Address;

@Entity
@Table(name = "student")
@DiscriminatorValue(value="STUDENT")
public class Student extends Member {
	public Student(String firstName, String lastName, String email, Set<String> images, List<String> books, 
			Map<String, String> projects, Address homeAddress) {
		super.setFirstName(firstName);
		super.setLastName(lastName);
		super.setEmail(email);
		super.setImages(images);
		super.setHomeAddress(homeAddress);
		this.projects = projects;
		this.books = books;
	}
	
	@ElementCollection
	@CollectionTable(name = "issuedBook", joinColumns = @JoinColumn(name = "student_id"))
	@Column(name = "book_name")
	@OrderColumn
	private List<String> books;
	
	@ElementCollection
	@CollectionTable(name = "studentProjects", joinColumns = @JoinColumn(name = "student_id"))
	@Column(name = "project_description")
	@MapKeyColumn(name="project_name")
	private Map<String, String> projects;
}