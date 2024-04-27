package com.example.demo20;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class Demo20Application {

	public static void main(String[] args) {

		SpringApplication.run(Demo20Application.class, args);

		System.out.println("Project started");

		Configuration cfg=new Configuration();
		cfg.configure("hibernate.config.xml");
		SessionFactory factory=cfg.buildSessionFactory();

		Employee e1=new Employee();
		Employee e2=new Employee();

		e1.setEid(101);;
		e1.setName("Tyson");
		e2.setEid(201);
		e2.setName("Kai");

		Project p1=new Project();
		Project p2=new Project();

		p1.setPid(1001);
		p2.setPid(2001);
		p1.setProjectName("DRAGOON");
		p2.setProjectName("DRANZER");

		List<Employee> list1=new ArrayList<Employee>();
		List<Project> list2=new ArrayList<Project>();

		list1.add(e1);
		list1.add(e2);
		list2.add(p1);
		list2.add(p2);

		e1.setProjects(list2);
		p2.setEmps(list1);

		Session session=factory.openSession();

		Transaction tx=session.beginTransaction();
		session.save(e1);
		session.save(e2);
		session.save(p1);
		session.save(p2);
		tx.commit(); //To commit the changes in our DB

//		//Fetching
//		Question q1=(Question) session.get(Question.class,101);
//		System.out.println(q1.getQuestion());
//		System.out.println(q1.getAnswer().getAnswer());

		System.out.println("Done");

		//System.out.println(sessionFactory);
		//System.out.println(sessionFactory.isClosed());

		session.close();
		factory.close();
	}

}
