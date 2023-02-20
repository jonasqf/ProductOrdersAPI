package ProductOrdersAPI.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ProductOrdersAPI.model.ItemOrder;
import ProductOrdersAPI.repository.ItemOrderRepository;

@Service
public class ItemOrderService {

	@Autowired
    ItemOrderRepository itemOrderRepository;

	public ItemOrder cadastrar(ItemOrder itemOrder) {

		return itemOrderRepository.save(itemOrder);
	}

	public Collection<ItemOrder> buscarTodos() {
		return itemOrderRepository.findAll();
	}

	public void excluir(ItemOrder itemOrder) {
		itemOrderRepository.delete(itemOrder);
	}

	public ItemOrder buscarPorId(Integer id) {
		return itemOrderRepository.findById(id).get();

	}

	public void atualizar(ItemOrder itemOrder) {
		itemOrderRepository.save(itemOrder);
	}

}
