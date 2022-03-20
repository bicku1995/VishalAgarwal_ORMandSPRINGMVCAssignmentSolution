package com.greatlearning.CRM;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/customers")
public class CustomerController {
	@Autowired
	private CustomerService customerService;

	@RequestMapping("/list")
	public String listCustomers(Model model) {
		List<Customer> customers = customerService.findAll();

		model.addAttribute("Customers", customers);

		return "list-customer";
	}

	@RequestMapping("/add")
	public String showFormForAdd(Model model) {
		Customer customer = new Customer();
		model.addAttribute("newCustomer", true);
		model.addAttribute("Customer", customer);

		return "Customer-form";
	}

	@RequestMapping("/update")
	public String showFormForUpdate(@RequestParam("id") int id, Model model) {
		Customer customer = customerService.findById(id);
		model.addAttribute("newCustomer", false);
		model.addAttribute("Customer", customer);

		return "Customer-form";
	}

	@RequestMapping("/delete")
	public String showFormForUpdate(@RequestParam("id") int id) {
		customerService.deleteById(id);

		return "redirect:/customers/list";
	}

	@PostMapping("/save")
	public String saveBook(@RequestParam("id") int id, @RequestParam("firstname") String firstname,
			@RequestParam("lastname") String lastname, @RequestParam("email") String email) {
		Customer customer = null;

		if (id == 0) {
			try {
				if (firstname.isEmpty() && lastname.isEmpty() && email.isEmpty())
					System.out.println("Customer FirstName, Customer LastName and Email cannot be blank");
				else
					customer = new Customer(firstname, lastname, email);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} else {
			customer = customerService.findById(id);
			customer.setFirstname(firstname);
			customer.setLastname(lastname);
			customer.setEmail(email);
		}
		if (!firstname.isEmpty() && !lastname.isEmpty() && !email.isEmpty()) {
			System.out.println(customer);
			customerService.save(customer);
		}

		// take the user automatically to the list of customers after new customer is saved
		return "redirect:/customers/list";
	}
}