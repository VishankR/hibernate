package com.hibenate.entities;

import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.Table;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.DiscriminatorType;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;

@Entity
@Table(name = "member")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "MEMBER_TYPE", discriminatorType = DiscriminatorType.STRING)
public class Member {
	@Column(name = "email")
	private String email;

	@Column(name = "first_name")
	private String firstName;

	@Embedded
	private Address homeAddress;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ElementCollection
	@CollectionTable(name = "image", joinColumns = @JoinColumn(name = "member_id"))
	@Column(name = "file_name")
	private Set<String> images;

	@Column(name = "last_name")
	private String lastName;

	public String getEmail() {
		return email;
	}

	public String getFirstName() {
		return firstName;
	}

	public Address getHomeAddress() {
		return homeAddress;
	}

	public int getId() {
		return id;
	}

	public Set<String> getImages() {
		return images;
	}

	public String getLastName() {
		return lastName;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setHomeAddress(Address homeAddress) {
		this.homeAddress = homeAddress;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public void setImages(Set<String> images) {
		this.images = images;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}