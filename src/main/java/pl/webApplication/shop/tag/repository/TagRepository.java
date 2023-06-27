package pl.webApplication.shop.tag.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.webApplication.shop.tag.model.Tag;

import java.util.List;

public interface TagRepository extends JpaRepository<Tag, Long> {

    List<Tag> findByProducts_Id(Long productId);
}
