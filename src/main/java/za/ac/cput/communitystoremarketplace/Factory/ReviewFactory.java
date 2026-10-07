package za.ac.cput.communitystoremarketplace.Factory;

import za.ac.cput.communitystoremarketplace.Domain.Review;
import za.ac.cput.communitystoremarketplace.util.Helper;

import java.util.Date;

public class ReviewFactory {
    public static Review createReview(Long reviewId, Long productId, Long reviewerId, int rating, String reviewComment, Date reviewDate) {

        if (productId != null
                && reviewerId != null
                && rating >= 1 && rating <= 5
                && !Helper.isNullorEmpty(reviewComment)) {

            return new Review.Builder()
                    .setReviewId(reviewId)
                    .setProductId(productId)
                    .setReviewerId(reviewerId)
                    .setRating(rating)
                    .setReviewComment(reviewComment)
                    .setReviewDate(reviewDate != null ? reviewDate : new Date())
                    .build();
        }
        return null;
    }
}
