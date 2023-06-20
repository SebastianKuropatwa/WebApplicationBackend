package pl.webApplication.shop.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.webApplication.shop.admin.model.AdminProduct;

public interface AdminProductRepository extends JpaRepository<AdminProduct, Long> {
}
