package ProductOrdersAPI.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ProductOrdersAPI.model.Order;
import ProductOrdersAPI.repository.OrderRepository;

@Service
public class OrderService {

	@Autowired
    OrderRepository orderRepository;

	public Order cadastrar(Order order) {

		return orderRepository.save(order);
	}

	public Collection<Order> buscarTodos() {
		return orderRepository.findAll();
	}

	public void excluir(Order order) {
		orderRepository.delete(order);
	}

	public Order buscarPorId(Integer id) {
		return orderRepository.findById(id).get();

	}

	public void atualizar(Order order) {
		orderRepository.save(order);
	}

}
