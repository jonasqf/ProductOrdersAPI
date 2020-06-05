package ProductOrdersAPI.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ProductOrdersAPI.model.ItemPedido;
import ProductOrdersAPI.repository.ItemPedidoRepository;

@Service
public class ItemPedidoService {

	@Autowired
	ItemPedidoRepository itemPedidoRepository;

	public ItemPedido cadastrar(ItemPedido itemPedido) {

		return itemPedidoRepository.save(itemPedido);
	}

	public Collection<ItemPedido> buscarTodos() {
		return itemPedidoRepository.findAll();
	}

	public void excluir(ItemPedido itemPedido) {
		itemPedidoRepository.delete(itemPedido);
	}

	public ItemPedido buscarPorId(Integer id) {
		return itemPedidoRepository.findById(id).get();

	}

	public void atualizar(ItemPedido itemPedido) {
		itemPedidoRepository.save(itemPedido);
	}

}
