package ProductOrdersAPI.customer.service;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ProductOrdersAPI.customer.model.Customer;
import ProductOrdersAPI.customer.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	CustomerRepository customerRepository;

	public Customer register(Customer customer) {

		return customerRepository.save(customer);
	}

	public Collection<Customer> findAll() {
		return customerRepository.findAll();
	}

	public void delete(Customer customer) {
		customerRepository.delete(customer);
	}

	public Customer findById(Integer id) {
		return customerRepository.findById(id).get();

	}

	public void update(Customer customer) {
		customerRepository.save(customer);
	}

}
