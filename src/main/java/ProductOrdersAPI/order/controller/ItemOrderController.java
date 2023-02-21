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

import ProductOrdersAPI.order.model.ItemOrder;
import ProductOrdersAPI.order.service.ItemOrderService;

@RestController
@RequestMapping("api/v1/itemOrders")
public class ItemOrderController {

	@Autowired
    ItemOrderService ItemOrderService;
	
	@RequestMapping(method = RequestMethod.POST, value = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ItemOrder> registerItemOrder(@RequestBody ItemOrder ItemOrder) {

		ItemOrder savedItemOrder = ItemOrderService.register(ItemOrder);
		return new ResponseEntity<>(savedItemOrder, HttpStatus.CREATED);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<ItemOrder>> findAll() {

		Collection<ItemOrder> allItemOrderFound = ItemOrderService.findAll();
		return new ResponseEntity<>(allItemOrderFound, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ItemOrder> findById(@PathVariable Integer id){
		ItemOrder foundItemOrderById = ItemOrderService.findByid(id);
		return new ResponseEntity<> (foundItemOrderById, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public ResponseEntity<ItemOrder> deleteItemOrder(@PathVariable Integer id) {

		ItemOrder deletedItemOrder = ItemOrderService.findByid(id);
		if (deletedItemOrder ==null) {
			return new ResponseEntity<>(deletedItemOrder, HttpStatus.NOT_FOUND);
		}
		ItemOrderService.delete(deletedItemOrder);
		return new ResponseEntity<>(deletedItemOrder, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ItemOrder> updateItemOrder(@RequestBody ItemOrder ItemOrder) {

		ItemOrderService.update(ItemOrder);
		return new ResponseEntity<>(ItemOrder, HttpStatus.OK);
	}

}
