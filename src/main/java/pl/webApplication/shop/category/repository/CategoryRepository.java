package pl.webApplication.shop.category.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.webApplication.shop.category.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
