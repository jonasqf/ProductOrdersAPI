package ProductOrdersAPI.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ProductOrdersAPI.product.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
	

}

