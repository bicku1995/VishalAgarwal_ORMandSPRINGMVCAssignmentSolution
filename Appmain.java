package com.greatlearning.CRM;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;



public class Appmain {

	public static void main(String[] args) {
		Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Customer.class);
		SessionFactory sessionFactory = con.buildSessionFactory();

		CustomerService customerService = new CustomerServiceImpl(sessionFactory);
		List<Customer> customerList = customerService.findAll();
		for (Customer customer : customerList) {
			System.out.println(customer.toString());
		}
		Customer customerById = customerService.findById(1);
		System.out.println(customerById.toString());

		Customer customerSave = new Customer("Sourav", "Dubey", "Sourav@gmail.com");
		customerService.save(customerSave);
		System.out.println("Customer details saved successfully!");

		// update book
		customerById.setLastName("New Author");
		customerService.save(customerById);
		System.out.println("Book updated successfully!");
		// delete
		try {
			customerService.deleteById(14);
			System.out.println("Customer details deleted successfully!");
		} catch (Exception e) {
			System.out.println("Cannot delete:: Customer details does not exists");
		}

			


	}

	}

