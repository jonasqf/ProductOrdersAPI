package ProductOrdersAPI.controller;

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

import ProductOrdersAPI.model.ItemPedido;
import ProductOrdersAPI.service.ItemPedidoService;

@RestController
public class ItemPedidoController {

	@Autowired
	ItemPedidoService ItemPedidoService;
	
	@RequestMapping(method = RequestMethod.POST, value = "/itemPedido", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ItemPedido> cadastrarItemPedido(@RequestBody ItemPedido ItemPedido) {

		ItemPedido ItemPedidoSalvo = ItemPedidoService.cadastrar(ItemPedido);
		System.out.println("cadastrou " + ItemPedidoSalvo.getId());
		return new ResponseEntity<>(ItemPedidoSalvo, HttpStatus.CREATED);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/itemPedido", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<ItemPedido>> buscarTodositemPedido() {

		Collection<ItemPedido> ItemPedidoBuscarTodos = ItemPedidoService.buscarTodos();
		System.out.println("buscou todos " + ItemPedidoBuscarTodos);
		return new ResponseEntity<>(ItemPedidoBuscarTodos, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/itemPedido/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ItemPedido> buscarPorId(@PathVariable Integer id){
		ItemPedido ItemPedidoPesquisadoPorId = ItemPedidoService.buscarPorId(id);
		return new ResponseEntity<> (ItemPedidoPesquisadoPorId, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/itemPedido/{id}")
	public ResponseEntity<ItemPedido> excluirItemPedido(@PathVariable Integer id) {

		ItemPedido ItemPedidoExcluido = ItemPedidoService.buscarPorId(id);
		if (ItemPedidoExcluido==null) {
			return new ResponseEntity<>(ItemPedidoExcluido, HttpStatus.NOT_FOUND);
		}
		System.out.println("excluiu " + ItemPedidoExcluido.getId());
		ItemPedidoService.excluir(ItemPedidoExcluido);
		return new ResponseEntity<>(ItemPedidoExcluido, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/itemPedido", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ItemPedido> atualizarItemPedido(@RequestBody ItemPedido ItemPedido) {

		ItemPedidoService.atualizar(ItemPedido);
		System.out.println("atualizou " + ItemPedido.getId());
		return new ResponseEntity<>(ItemPedido, HttpStatus.OK);
	}

}
