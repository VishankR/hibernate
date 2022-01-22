package com.hibenate.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.MapKeyColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

@Entity
@Table(name = "student")
//@DiscriminatorValue(value="STUDENT")
public class Student /* extends Member */ {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	/*
	 * @ElementCollection
	 * 
	 * @CollectionTable(name = "issuedBook", joinColumns = @JoinColumn(name =
	 * "student_id"))
	 * 
	 * @Column(name = "book_name")
	 * 
	 * @OrderColumn private List<String> books;
	 */

	
	  @OneToOne(cascade = CascadeType.ALL)  
	 // @JoinColumn(name = "performancelog_id") 
	  private MemberDetail memDetail;
	 

	public MemberDetail getMemDetail() {
		return memDetail;
	}

	public void setMemDetail(MemberDetail memDetail) {
		this.memDetail = memDetail;
	}

	/*
	 * @ElementCollection
	 * 
	 * @CollectionTable(name = "studentProjects", joinColumns = @JoinColumn(name =
	 * "student_id"))
	 * 
	 * @Column(name = "project_description")
	 * 
	 * @MapKeyColumn(name = "project_name") private Map<String, String> projects;
	 */
	@ManyToMany(cascade = CascadeType.ALL, mappedBy = "studentList")
	@ElementCollection
	List<FeeReceipt> receiptList;

	public Student(/*
					 * String firstName, String lastName, String email, Set<String> images, Address
					 * homeAddress, Map<String, String> projects, List<String> books, MemberDetail
					 * memDetail
					 */) {
		/*
		 * super.setFirstName(firstName); super.setLastName(lastName);
		 * super.setEmail(email); super.setImages(images);
		 * super.setHomeAddress(homeAddress);
		 * 
		 * this.projects = projects; this.books = books;
		 */
		/* this.memDetail = memDetail; */
	}

	public List<FeeReceipt> getReceiptList() {
		return receiptList;
	}

	public void setReceiptList(List<FeeReceipt> receiptList) {
		this.receiptList = receiptList;
	}
}