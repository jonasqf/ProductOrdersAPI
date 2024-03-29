package ProductOrdersAPI.customer.controller;

import java.util.Collection;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ProductOrdersAPI.customer.model.Customer;
import ProductOrdersAPI.customer.service.CustomerService;

@RestController
@Api(value="Customer")
@RequestMapping("api/v1/customers")
public class CustomerController {
    
	@Autowired
	CustomerService customerService;

	@ApiOperation(value = "Register a new customer")
	@RequestMapping(method = RequestMethod.POST, value = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Customer> registerCustomer(@RequestBody Customer customer) {

		Customer newCustomer = customerService.register(customer);
		return new ResponseEntity<>(newCustomer, HttpStatus.CREATED);
	}

	@ApiOperation(value = "Find all Customers")
	@RequestMapping(method = RequestMethod.GET, value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<Customer>> findAllCustomers() {

		Collection<Customer> findAllCustomers = customerService.findAll();
		return new ResponseEntity<>(findAllCustomers, HttpStatus.OK);
	}

	@ApiOperation(value = "Find Customers by ID")
	@RequestMapping(method = RequestMethod.GET, value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Customer> findCustomerById(@PathVariable Integer id){
		Customer findCustomerById = customerService.findById(id);
		return new ResponseEntity<> (findCustomerById, HttpStatus.OK);
	}

	@ApiOperation(value = "Delete a customer")
	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public ResponseEntity<Customer> deleteCustomer(@PathVariable Integer id) {

		Customer deletedCustomer = customerService.findById(id);
		if (deletedCustomer ==null) {
			return new ResponseEntity<>(deletedCustomer, HttpStatus.NOT_FOUND);
		}
		customerService.delete(deletedCustomer);
		return new ResponseEntity<>(deletedCustomer, HttpStatus.OK);
	}

	@ApiOperation(value = "Update a customer")
	@RequestMapping(method = RequestMethod.PUT, value = "/", consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer) {

		customerService.update(customer);
		return new ResponseEntity<>(customer, HttpStatus.OK);
	}

}
