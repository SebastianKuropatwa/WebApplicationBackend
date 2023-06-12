package pl.webApplication.shop.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.webApplication.shop.product.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
