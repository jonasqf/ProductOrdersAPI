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
@RequestMapping("api/v1/products")
public class ProductController {

	@Autowired
	ProductService ProductService;
	
	@RequestMapping(method = RequestMethod.POST, value = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Product> createProduct(@RequestBody Product Product) {

		Product savedProduct = ProductService.register(Product);
		return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<Product>> findAllProducts() {

		Collection<Product> findAllProducts = ProductService.findAll();
		return new ResponseEntity<>(findAllProducts, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Product> findById(@PathVariable Integer id){
		Product productById = ProductService.findById(id);
		return new ResponseEntity<> (productById, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public ResponseEntity<Product> deleteProduct(@PathVariable Integer id) {

		Product productDeleted = ProductService.findById(id);
		if (productDeleted ==null) {
			return new ResponseEntity<>(productDeleted, HttpStatus.NOT_FOUND);
		}
		ProductService.delete(productDeleted);
		return new ResponseEntity<>(productDeleted, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Product> updateProduct(@RequestBody Product Product) {

		ProductService.update(Product);
		return new ResponseEntity<>(Product, HttpStatus.OK);
	}

}
