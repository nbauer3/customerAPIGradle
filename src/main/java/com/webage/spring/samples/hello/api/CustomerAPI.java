package com.webage.spring.samples.hello.api;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerAPI
{
	private Customer cust1 = new Customer("Nick", "nb@bah.com", "password");
	private Customer cust2 = new Customer("Matt", "m@bah.com", "password2");
	private Customer cust3 = new Customer("Mike", "mike@bah.com", "password3");
	
	private ArrayList<Customer> list = new ArrayList<Customer>();	

	@GetMapping("/Customer")
	public Customer getMessage()
	{
		return new Customer("Nick", "nb@bah.com", "password");
	}
	
	@GetMapping("/Customer/all")
	public ArrayList<Customer> getAll()
	{
		list.add(cust1);
		list.add(cust2);
		list.add(cust3);
		
		return list;
	}
	
	@GetMapping("/Customer/name/{name}")
	public Customer getCustomerByName(@PathVariable String name)
	{
		for(int i = 0; i <= list.size(); i++)
		{
			if(list.get(i).name.equals(name))
			{
				return list.get(i);
			}
		}
		return null;
	}
	
	@GetMapping("/Customer/email/{email}")
	public Customer getCustomerByEmail(@PathVariable String email)
	{
		for(int i = 0; i <= list.size(); i++)
		{			
			if(list.get(i).email.equals(email))
			{
				return list.get(i);
			}
		}
		return null;
	}
	
}
