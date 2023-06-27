package pl.webApplication.shop.product.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import pl.webApplication.shop.product.model.Product;

import java.awt.print.Pageable;

public interface ProductRepository extends JpaRepository<Product, Long> {
//    Page<Product> findByCategoryId(Long id, Pageable pageable);

}
