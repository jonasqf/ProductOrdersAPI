package ProductOrdersAPI.product.repository;

import ProductOrdersAPI.product.model.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class ProductRepositoryTest {

    @Autowired
    private ProductRepository underTest;

    @Test
    void itShouldRegisterAProductStatusUnavailable(){
        //given
        String expected = "NOT_AVAILABLE";
        Product product = new Product("Test Product", 0.00F);
        //when
        underTest.save(product);
        //then
        assertThat(product.getProductStatus()).isEqualTo(expected);
    }
}