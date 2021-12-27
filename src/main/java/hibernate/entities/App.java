package hibernate.entities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibenate.entities.Student;

public class App {

	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class).buildSessionFactory();
		HashSet<String> images = new HashSet<>();
		List<String> books = new ArrayList<String>();
		Map<String, String> projects = new HashMap<String, String>();
		Address homeAddress = new Address("1 Main St", "Philadelphia", "19103");
		projects.put("project1", "project1 desc");
		projects.put("project2", "project2 desc");
		books.add("Morris Mano");
		books.add("DSP");
		images.add("image1");
		images.add("image2");
		Student tempStudent = new Student("Paul","Wall","paul@luv2code.com", images, books, projects, homeAddress);
		Session session = sf.openSession();
		session.beginTransaction();
		System.out.println("Saving the student and images..");
		session.persist(tempStudent);
		session.getTransaction().commit();
		session.close();
	}

}
