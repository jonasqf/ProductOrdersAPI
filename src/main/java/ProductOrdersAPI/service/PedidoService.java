package ProductOrdersAPI.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ProductOrdersAPI.model.Pedido;
import ProductOrdersAPI.repository.PedidoRepository;

@Service
public class PedidoService {

	@Autowired
	PedidoRepository pedidoRepository;

	public Pedido cadastrar(Pedido pedido) {

		return pedidoRepository.save(pedido);
	}

	public Collection<Pedido> buscarTodos() {
		return pedidoRepository.findAll();
	}

	public void excluir(Pedido pedido) {
		pedidoRepository.delete(pedido);
	}

	public Pedido buscarPorId(Integer id) {
		return pedidoRepository.findById(id).get();

	}

	public void atualizar(Pedido pedido) {
		pedidoRepository.save(pedido);
	}

}
