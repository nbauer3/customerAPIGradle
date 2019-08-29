package com.webage.spring.samples.hello.repo;

import org.springframework.data.repository.CrudRepository;
import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.webage.spring.samples.hello.api.Customer;

@Component
public interface CustomerRepo extends CrudRepository<Customer, Long>
{
	/*
	 * private Customer cust1 = new Customer("Nick", "nb@bah.com", "password");
	 * private Customer cust2 = new Customer("Matt", "m@bah.com", "password2");
	 * private Customer cust3 = new Customer("Mike", "mike@bah.com", "password3");
	 * private Customer cust4 = new Customer("Timmy", "timmy@bah.com", "password4");
	 * private Customer cust5 = new Customer("Mitch", "mitch@bah.com",
	 * "password5555");
	 * 
	 * private ArrayList<Customer> list = new ArrayList<Customer>();
	 * 
	 * public CustomerRepo() { list.add(cust1); list.add(cust2); list.add(cust3);
	 * list.add(cust4); list.add(cust5); }
	 * 
	 * public ArrayList<Customer> getAllCustomers() { return list; }
	 * 
	 * public Customer getCustomerByName(String name) { for (Customer customer :
	 * list) { if (customer.getName().equalsIgnoreCase(name)) { return customer; } }
	 * return null; }
	 * 
	 * public Customer getCustomerByEmail(String email) { for (Customer customer :
	 * list) { if (customer.getEmail().equalsIgnoreCase(email)) { return customer; }
	 * } return null; }
	 * 
	 * public Customer save(Customer customer) { Customer existing =
	 * getCustomerByName(customer.getName()); if(existing != null) {
	 * existing.setEmail(customer.getEmail()); return existing; } else {
	 * list.add(customer); return customer; } }
	 */
}
