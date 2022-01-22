package com.hibenate.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class FeeReceipt {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "performance_id")
    private List<Student> studentList;
	
	public String getName() {
		return name;
	}

	public FeeReceipt(String name) {
		super();
		this.name = name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private String name;
}
