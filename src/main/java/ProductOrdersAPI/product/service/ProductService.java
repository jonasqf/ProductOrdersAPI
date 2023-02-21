package ProductOrdersAPI.product.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ProductOrdersAPI.product.model.Product;
import ProductOrdersAPI.product.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	ProductRepository productRepository;

	public Product register(Product product) {

		return productRepository.save(product);
	}

	public Collection<Product> findAll() {
		return productRepository.findAll();
	}

	public void delete(Product product) {
		productRepository.delete(product);
	}

	public Product findById(Integer id) {
		return productRepository.findById(id).get();

	}

	public void update(Product product) {
		productRepository.save(product);
	}

}
