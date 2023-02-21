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
public class OrderController {

	@Autowired
    OrderService OrderService;
	
	@RequestMapping(method = RequestMethod.POST, value = "/pedido", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Order> cadastrarPedido(@RequestBody Order Order) {

		Order orderSalvo = OrderService.cadastrar(Order);
		System.out.println("cadastrou " + orderSalvo.getId());
		return new ResponseEntity<>(orderSalvo, HttpStatus.CREATED);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/pedido", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<Order>> buscarTodospedido() {

		Collection<Order> orderBuscarTodos = OrderService.buscarTodos();
		System.out.println("buscou todos " + orderBuscarTodos);
		return new ResponseEntity<>(orderBuscarTodos, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/pedido/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Order> buscarPorId(@PathVariable Integer id){
		Order orderPesquisadoPorId = OrderService.buscarPorId(id);
		return new ResponseEntity<> (orderPesquisadoPorId, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/pedido/{id}")
	public ResponseEntity<Order> excluirPedido(@PathVariable Integer id) {

		Order orderExcluido = OrderService.buscarPorId(id);
		if (orderExcluido ==null) {
			return new ResponseEntity<>(orderExcluido, HttpStatus.NOT_FOUND);
		}
		System.out.println("excluiu " + orderExcluido.getId());
		OrderService.excluir(orderExcluido);
		return new ResponseEntity<>(orderExcluido, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/pedido", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Order> atualizarPedido(@RequestBody Order Order) {

		OrderService.atualizar(Order);
		System.out.println("atualizou " + Order.getId());
		return new ResponseEntity<>(Order, HttpStatus.OK);
	}

}
