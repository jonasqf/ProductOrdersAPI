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
public class ItemOrderController {

	@Autowired
    ItemOrderService ItemOrderService;
	
	@RequestMapping(method = RequestMethod.POST, value = "/itemPedido", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ItemOrder> cadastrarItemPedido(@RequestBody ItemOrder ItemOrder) {

		ItemOrder itemOrderSalvo = ItemOrderService.cadastrar(ItemOrder);
		System.out.println("cadastrou " + itemOrderSalvo.getId());
		return new ResponseEntity<>(itemOrderSalvo, HttpStatus.CREATED);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/itemPedido", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<ItemOrder>> buscarTodositemPedido() {

		Collection<ItemOrder> itemOrderBuscarTodos = ItemOrderService.buscarTodos();
		System.out.println("buscou todos " + itemOrderBuscarTodos);
		return new ResponseEntity<>(itemOrderBuscarTodos, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/itemPedido/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ItemOrder> buscarPorId(@PathVariable Integer id){
		ItemOrder itemOrderPesquisadoPorId = ItemOrderService.buscarPorId(id);
		return new ResponseEntity<> (itemOrderPesquisadoPorId, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/itemPedido/{id}")
	public ResponseEntity<ItemOrder> excluirItemPedido(@PathVariable Integer id) {

		ItemOrder itemOrderExcluido = ItemOrderService.buscarPorId(id);
		if (itemOrderExcluido ==null) {
			return new ResponseEntity<>(itemOrderExcluido, HttpStatus.NOT_FOUND);
		}
		System.out.println("excluiu " + itemOrderExcluido.getId());
		ItemOrderService.excluir(itemOrderExcluido);
		return new ResponseEntity<>(itemOrderExcluido, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/itemPedido", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ItemOrder> atualizarItemPedido(@RequestBody ItemOrder ItemOrder) {

		ItemOrderService.atualizar(ItemOrder);
		System.out.println("atualizou " + ItemOrder.getId());
		return new ResponseEntity<>(ItemOrder, HttpStatus.OK);
	}

}
