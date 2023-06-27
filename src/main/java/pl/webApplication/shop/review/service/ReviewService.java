package pl.webApplication.shop.review.service;

import org.springframework.stereotype.Service;
import pl.webApplication.shop.review.model.Review;
import pl.webApplication.shop.review.repository.ReviewRepository;

import java.util.Optional;

@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;

    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public Review getReviewById(Long id) {
        Optional<Review> optionalReview = reviewRepository.findById(id);
        return optionalReview.orElse(null);
    }

    public Review createReview(Review review) {
        return reviewRepository.save(review);
    }

    public Review updateReview(Long id, Review updatedReview) {
        Optional<Review> optionalReview = reviewRepository.findById(id);
        if (optionalReview.isPresent()) {
            Review existingReview = optionalReview.get();
            existingReview.setTitle(updatedReview.getTitle());
            existingReview.setContent(updatedReview.getContent());

            return reviewRepository.save(existingReview);
        }
        return null;
    }

    public boolean deleteReview(Long id) {
        if (reviewRepository.existsById(id)) {
            reviewRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Optional<Review> getReviewsByProductId(Long productId) {
        return reviewRepository.findById(productId);
    }
}

