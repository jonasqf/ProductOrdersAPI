package ProductOrdersAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ProductOrdersAPI.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
	

}

