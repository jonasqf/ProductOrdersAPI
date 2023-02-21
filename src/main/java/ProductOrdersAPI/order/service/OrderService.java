package ProductOrdersAPI.order.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ProductOrdersAPI.order.model.Order;
import ProductOrdersAPI.order.repository.OrderRepository;

@Service
public class OrderService {

	@Autowired
    OrderRepository orderRepository;

	public Order register(Order order) {

		return orderRepository.save(order);
	}

	public Collection<Order> findAll() {
		return orderRepository.findAll();
	}

	public void delete(Order order) {
		orderRepository.delete(order);
	}

	public Order findById(Integer id) {
		return orderRepository.findById(id).get();

	}

	public void update(Order order) {
		orderRepository.save(order);
	}

}
