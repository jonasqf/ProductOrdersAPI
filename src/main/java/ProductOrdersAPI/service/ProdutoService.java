package ProductOrdersAPI.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ProductOrdersAPI.model.Produto;
import ProductOrdersAPI.repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	ProdutoRepository produtoRepository;

	public Produto cadastrar(Produto produto) {

		return produtoRepository.save(produto);
	}

	public Collection<Produto> buscarTodos() {
		return produtoRepository.findAll();
	}

	public void excluir(Produto produto) {
		produtoRepository.delete(produto);
	}

	public Produto buscarPorId(Integer id) {
		return produtoRepository.findById(id).get();

	}

	public void atualizar(Produto produto) {
		produtoRepository.save(produto);
	}

}
