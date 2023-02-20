package ProductOrdersAPI.product.controller;

import java.util.Collection;

import ProductOrdersAPI.product.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ProductOrdersAPI.product.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	ProductService ProductService;
	
	@RequestMapping(method = RequestMethod.POST, value = "/produto", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Product> createProduct(@RequestBody Product Product) {

		Product productSalvo = ProductService.cadastrar(Product);
		System.out.println("cadastrou " + productSalvo.getNomeProduto());
		return new ResponseEntity<>(productSalvo, HttpStatus.CREATED);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/produto", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<Product>> buscarTodosproduto() {

		Collection<Product> productBuscarTodos = ProductService.buscarTodos();
		System.out.println("buscou todos " + productBuscarTodos);
		return new ResponseEntity<>(productBuscarTodos, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/produto/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Product> buscarPorId(@PathVariable Integer id){
		Product productPesquisadoPorId = ProductService.buscarPorId(id);
		return new ResponseEntity<> (productPesquisadoPorId, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/produto/{id}")
	public ResponseEntity<Product> excluirProduto(@PathVariable Integer id) {

		Product productExcluido = ProductService.buscarPorId(id);
		if (productExcluido ==null) {
			return new ResponseEntity<>(productExcluido, HttpStatus.NOT_FOUND);
		}
		System.out.println("excluiu " + productExcluido.getNomeProduto());
		ProductService.excluir(productExcluido);
		return new ResponseEntity<>(productExcluido, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/produto", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Product> atualizarProduto(@RequestBody Product Product) {

		ProductService.atualizar(Product);
		System.out.println("atualizou " + Product.getNomeProduto());
		return new ResponseEntity<>(Product, HttpStatus.OK);
	}

}
