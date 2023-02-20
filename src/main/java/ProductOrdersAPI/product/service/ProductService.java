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

	public Product cadastrar(Product product) {

		return productRepository.save(product);
	}

	public Collection<Product> buscarTodos() {
		return productRepository.findAll();
	}

	public void excluir(Product product) {
		productRepository.delete(product);
	}

	public Product buscarPorId(Integer id) {
		return productRepository.findById(id).get();

	}

	public void atualizar(Product product) {
		productRepository.save(product);
	}

}
