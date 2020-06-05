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

import ProductOrdersAPI.model.Pedido;
import ProductOrdersAPI.service.PedidoService;

@RestController
public class PedidoController {

	@Autowired
	PedidoService PedidoService;
	
	@RequestMapping(method = RequestMethod.POST, value = "/pedido", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Pedido> cadastrarPedido(@RequestBody Pedido Pedido) {

		Pedido PedidoSalvo = PedidoService.cadastrar(Pedido);
		System.out.println("cadastrou " + PedidoSalvo.getId());
		return new ResponseEntity<>(PedidoSalvo, HttpStatus.CREATED);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/pedido", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<Pedido>> buscarTodospedido() {

		Collection<Pedido> PedidoBuscarTodos = PedidoService.buscarTodos();
		System.out.println("buscou todos " + PedidoBuscarTodos);
		return new ResponseEntity<>(PedidoBuscarTodos, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/pedido/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Pedido> buscarPorId(@PathVariable Integer id){
		Pedido PedidoPesquisadoPorId = PedidoService.buscarPorId(id);
		return new ResponseEntity<> (PedidoPesquisadoPorId, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/pedido/{id}")
	public ResponseEntity<Pedido> excluirPedido(@PathVariable Integer id) {

		Pedido PedidoExcluido = PedidoService.buscarPorId(id);
		if (PedidoExcluido==null) {
			return new ResponseEntity<>(PedidoExcluido, HttpStatus.NOT_FOUND);
		}
		System.out.println("excluiu " + PedidoExcluido.getId());
		PedidoService.excluir(PedidoExcluido);
		return new ResponseEntity<>(PedidoExcluido, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/pedido", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Pedido> atualizarPedido(@RequestBody Pedido Pedido) {

		PedidoService.atualizar(Pedido);
		System.out.println("atualizou " + Pedido.getId());
		return new ResponseEntity<>(Pedido, HttpStatus.OK);
	}

}
