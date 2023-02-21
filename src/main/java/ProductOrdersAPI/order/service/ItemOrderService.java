package ProductOrdersAPI.order.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ProductOrdersAPI.order.model.ItemOrder;
import ProductOrdersAPI.order.repository.ItemOrderRepository;

@Service
public class ItemOrderService {

	@Autowired
    ItemOrderRepository itemOrderRepository;

	public ItemOrder register(ItemOrder itemOrder) {

		return itemOrderRepository.save(itemOrder);
	}

	public Collection<ItemOrder> findAll() {
		return itemOrderRepository.findAll();
	}

	public void delete(ItemOrder itemOrder) {
		itemOrderRepository.delete(itemOrder);
	}

	public ItemOrder findByid(Integer id) {
		return itemOrderRepository.findById(id).get();

	}

	public void update(ItemOrder itemOrder) {
		itemOrderRepository.save(itemOrder);
	}

}
