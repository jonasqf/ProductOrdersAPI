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

import ProductOrdersAPI.model.Produto;
import ProductOrdersAPI.service.ProdutoService;

@RestController
public class ProdutoController {

	@Autowired
	ProdutoService ProdutoService;
	
	@RequestMapping(method = RequestMethod.POST, value = "/produto", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Produto> cadastrarProduto(@RequestBody Produto Produto) {

		Produto ProdutoSalvo = ProdutoService.cadastrar(Produto);
		System.out.println("cadastrou " + ProdutoSalvo.getNomeProduto());
		return new ResponseEntity<>(ProdutoSalvo, HttpStatus.CREATED);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/produto", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<Produto>> buscarTodosproduto() {

		Collection<Produto> ProdutoBuscarTodos = ProdutoService.buscarTodos();
		System.out.println("buscou todos " + ProdutoBuscarTodos);
		return new ResponseEntity<>(ProdutoBuscarTodos, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/produto/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Produto> buscarPorId(@PathVariable Integer id){
		Produto ProdutoPesquisadoPorId = ProdutoService.buscarPorId(id);
		return new ResponseEntity<> (ProdutoPesquisadoPorId, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/produto/{id}")
	public ResponseEntity<Produto> excluirProduto(@PathVariable Integer id) {

		Produto ProdutoExcluido = ProdutoService.buscarPorId(id);
		if (ProdutoExcluido==null) {
			return new ResponseEntity<>(ProdutoExcluido, HttpStatus.NOT_FOUND);
		}
		System.out.println("excluiu " + ProdutoExcluido.getNomeProduto());
		ProdutoService.excluir(ProdutoExcluido);
		return new ResponseEntity<>(ProdutoExcluido, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/produto", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Produto> atualizarProduto(@RequestBody Produto Produto) {

		ProdutoService.atualizar(Produto);
		System.out.println("atualizou " + Produto.getNomeProduto());
		return new ResponseEntity<>(Produto, HttpStatus.OK);
	}

}
