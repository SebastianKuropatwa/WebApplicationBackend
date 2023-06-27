package pl.webApplication.shop.review.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.webApplication.shop.review.model.Review;

public interface ReviewRepository extends JpaRepository <Review, Long> {


}
