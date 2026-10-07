package za.ac.cput.communitystoremarketplace.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.communitystoremarketplace.Domain.Review;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findByProductId(Long productId);
    List<Review> findByReviewerId(Long reviewerId);
}
