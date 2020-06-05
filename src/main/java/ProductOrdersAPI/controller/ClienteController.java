package ProductOrdersAPI.controller;

import java.util.Collection;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ProductOrdersAPI.model.Cliente;
import ProductOrdersAPI.service.ClienteService;

@RestController
@Api(value="Cliente")
public class ClienteController {
    
	@Autowired
	ClienteService clienteService;

	@ApiOperation(value = "Cadastrar um Novo Cliente")
	@RequestMapping(method = RequestMethod.POST, value = "/clientes", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Cliente> cadastrarCliente(@RequestBody Cliente cliente) {

		Cliente clienteSalvo = clienteService.cadastrar(cliente);
		System.out.println("cadastrou " + clienteSalvo.getNome());
		return new ResponseEntity<>(clienteSalvo, HttpStatus.CREATED);
	}

	@ApiOperation(value = "Buscar Todos os Cliente")
	@RequestMapping(method = RequestMethod.GET, value = "/clientes", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<Cliente>> buscarTodosClientes() {

		Collection<Cliente> clienteBuscarTodos = clienteService.buscarTodos();
		System.out.println("buscou todos " + clienteBuscarTodos);
		return new ResponseEntity<>(clienteBuscarTodos, HttpStatus.OK);
	}

	@ApiOperation(value = "Buscar um Cliente por ID")
	@RequestMapping(method = RequestMethod.GET, value = "/clientes/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Cliente> buscarPorId(@PathVariable Integer id){
		Cliente clientePesquisadoPorId = clienteService.buscarPorId(id);
		return new ResponseEntity<> (clientePesquisadoPorId, HttpStatus.OK);
	}

	@ApiOperation(value = "Excluir um Cliente")
	@RequestMapping(method = RequestMethod.DELETE, value = "/clientes/{id}")
	public ResponseEntity<Cliente> excluirCliente(@PathVariable Integer id) {

		Cliente clienteExcluido = clienteService.buscarPorId(id);
		if (clienteExcluido==null) {
			return new ResponseEntity<>(clienteExcluido, HttpStatus.NOT_FOUND);
		}
		System.out.println("excluiu " + clienteExcluido.getNome());
		clienteService.excluir(clienteExcluido);
		return new ResponseEntity<>(clienteExcluido, HttpStatus.OK);
	}

	@ApiOperation(value = "Atualizar um Cliente")
	@RequestMapping(method = RequestMethod.PUT, value = "/clientes", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Cliente> atualizarCliente(@RequestBody Cliente cliente) {

		clienteService.atualizar(cliente);
		System.out.println("atualizou " + cliente.getNome());
		return new ResponseEntity<>(cliente, HttpStatus.OK);
	}

}
