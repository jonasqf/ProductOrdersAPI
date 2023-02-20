package ProductOrdersAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ProductOrdersAPI.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
	

}
