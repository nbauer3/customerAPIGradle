package com.webage.spring.samples.hello.api;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import com.webage.spring.samples.hello.repo.CustomerRepo;

@RestController
@RequestMapping("/Customer")
public class CustomerAPI
{
	@Autowired
	private CustomerRepo custRepo;

	//GET @ http://localhost:8080/Customer
	//returns all customers
	@GetMapping
	public Iterable<Customer> iterate()
	{
		return custRepo.findAll();
	}
	
	//GET @ http://localhost:8080/Customer/name/ <insert name>
	//returns customers by name
	@GetMapping("/name/{name}")
	public Customer getByName(@PathVariable("name") String custName)
	{
		Iterable<Customer> list = iterate();
		for(Customer cust : list)
		{
			if(cust.getName().equalsIgnoreCase(custName))
			{
				return cust;
			}
		}
		return null;
	}
	
	//GET @ http://localhost:8080/Customer/ <insert id>
	
	@GetMapping("/{id}")
	public Customer getById(@PathVariable("id") long custID)
	{
		return custRepo.findById(custID).orElse(null);
	}
	
	
	//POST @ http://localhost:8080/Customer
	@PostMapping
	public ResponseEntity<?> addCustomer(@RequestBody Customer newCustomer, UriComponentsBuilder uri)
	{
		if (newCustomer.getName() == null || newCustomer.getEmail() == null)
		{
			return ResponseEntity.badRequest().build();
		}
		newCustomer = custRepo.save(newCustomer);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{name}")
				.buildAndExpand(newCustomer.getName()).toUri();
		ResponseEntity<?> response = ResponseEntity.created(location).build();
		return response;
	}
	
	//PUT @ http://localhost:8080/Customer/name/<insert name>
	@PutMapping("/name/{name}")
	public ResponseEntity<?> putCustomerByName(@RequestBody Customer newCustomer, @PathVariable("name") String custName)
	{
		if (newCustomer.getName() == custName || newCustomer.getName() == null || newCustomer.getEmail() == null)
		{
			return ResponseEntity.badRequest().build();
		}
		else
		{
			newCustomer.setId(getByName(custName).getId());
		}
		
		newCustomer = custRepo.save(newCustomer);
		return ResponseEntity.ok().build();
	}
	
	//DELETE @ http://localhost:8080/Customer/name/<insert name>
	//id doesn't reset
	@DeleteMapping("/name/{name}")
	public ResponseEntity<?> deleteCustomer(@PathVariable String name)
	{
		custRepo.delete(getByName(name));
		return new ResponseEntity<String>("Customer " + name + " was deleted.", HttpStatus.OK);
	}
	
	/*
	 * //PUT @ http://localhost:8080/Customer/email/<insert email>
	 * 
	 * @PutMapping("/email/{email}") public ResponseEntity<?>
	 * putCustomerByEmail(@RequestBody Customer newCustomer, @PathVariable("email")
	 * String custEmail) { if (newCustomer.getEmail() == custEmail ||
	 * newCustomer.getEmail() == null || newCustomer.getEmail() == null) { return
	 * ResponseEntity.badRequest().build(); } newCustomer =
	 * custRepo.save(newCustomer); return ResponseEntity.ok().build(); }
	 */
}
