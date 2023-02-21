package ProductOrdersAPI.order.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ProductOrdersAPI.order.model.Order;
import ProductOrdersAPI.order.service.OrderService;

@RestController
@RequestMapping("api/v1/orders")
public class OrderController {

	@Autowired
    OrderService OrderService;
	
	@RequestMapping(method = RequestMethod.POST, value = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Order> registerOrder(@RequestBody Order Order) {

		Order savedOrder = OrderService.register(Order);
		return new ResponseEntity<>(savedOrder, HttpStatus.CREATED);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<Order>> findAll() {

		Collection<Order> allOrdersFound = OrderService.findAll();
		return new ResponseEntity<>(allOrdersFound, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Order> findById(@PathVariable Integer id){
		Order orderFoundById = OrderService.findById(id);
		return new ResponseEntity<> (orderFoundById, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public ResponseEntity<Order> deleteOrder(@PathVariable Integer id) {

		Order deletedOrder = OrderService.findById(id);
		if (deletedOrder ==null) {
			return new ResponseEntity<>(deletedOrder, HttpStatus.NOT_FOUND);
		}
		OrderService.delete(deletedOrder);
		return new ResponseEntity<>(deletedOrder, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Order> updateOrder(@RequestBody Order Order) {

		OrderService.update(Order);
		return new ResponseEntity<>(Order, HttpStatus.OK);
	}

}
