package za.ac.cput.communitystoremarketplace.Service;

import za.ac.cput.communitystoremarketplace.Domain.Review;

import java.util.List;

public interface IReviewService extends IService<Review, Long> {
    List<Review> getAll();
    List<Review> getByProductId(Long productId);
    List<Review> getByReviewerId(Long reviewerId);
}
