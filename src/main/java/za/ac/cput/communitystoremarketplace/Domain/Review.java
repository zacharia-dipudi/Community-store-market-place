package za.ac.cput.communitystoremarketplace.Domain;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "review")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewId;
    private Long productId;
    private Long reviewerId;
    private int rating; // 1 to 5
    @Column(length = 2000)
    private String reviewComment;
    @Temporal(TemporalType.TIMESTAMP)
    private Date reviewDate;

    public Review(Long reviewId, Long productId, Long reviewerId, int rating, String reviewComment, Date reviewDate) {
        this.reviewId = reviewId;
        this.productId = productId;
        this.reviewerId = reviewerId;
        this.rating = rating;
        this.reviewComment = reviewComment;
        this.reviewDate = reviewDate;
    }

    private Review(Builder builder) {
        this.reviewId = builder.reviewId;
        this.productId = builder.productId;
        this.reviewerId = builder.reviewerId;
        this.rating = builder.rating;
        this.reviewComment = builder.reviewComment;
        this.reviewDate = builder.reviewDate;
    }

    public Review() {
    }

    public Long getReviewId() { return reviewId; }
    public void setReviewId(Long reviewId) { this.reviewId = reviewId; }

    public Long getProductId() { return productId; }
    public void setProductId(Long productId) { this.productId = productId; }

    public Long getReviewerId() { return reviewerId; }
    public void setReviewerId(Long reviewerId) { this.reviewerId = reviewerId; }

    public int getRating() { return rating; }
    public void setRating(int rating) { this.rating = rating; }

    public String getReviewComment() { return reviewComment; }
    public void setReviewComment(String reviewComment) { this.reviewComment = reviewComment; }

    public Date getReviewDate() { return reviewDate; }
    public void setReviewDate(Date reviewDate) { this.reviewDate = reviewDate; }

    public static class Builder {
        private Long reviewId;
        private Long productId;
        private Long reviewerId;
        private int rating;
        private String reviewComment;
        private Date reviewDate;

        public Builder setReviewId(Long reviewId) {
            this.reviewId = reviewId;
            return this;
        }
        public Builder setProductId(Long productId) {
            this.productId = productId;
            return this;
        }
        public Builder setReviewerId(Long reviewerId) {
            this.reviewerId = reviewerId;
            return this;
        }
        public Builder setRating(int rating) {
            this.rating = rating;
            return this;
        }
        public Builder setReviewComment(String reviewComment) {
            this.reviewComment = reviewComment;
            return this;
        }
        public Builder setReviewDate(Date reviewDate) {
            this.reviewDate = reviewDate;
            return this;
        }
        public Review build() {
            return new Review(this);
        }
    }
}
