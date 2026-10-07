package za.ac.cput.communitystoremarketplace.Domain;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "favorite",
        uniqueConstraints = @UniqueConstraint(columnNames = {"userId", "productId"}))
public class Favorite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long favoriteId;
    private Long userId;
    private Long productId;
    @Temporal(TemporalType.TIMESTAMP)
    private Date favoriteDate;

    public Favorite(Long favoriteId, Long userId, Long productId, Date favoriteDate) {
        this.favoriteId = favoriteId;
        this.userId = userId;
        this.productId = productId;
        this.favoriteDate = favoriteDate;
    }

    private Favorite(Builder builder) {
        this.favoriteId = builder.favoriteId;
        this.userId = builder.userId;
        this.productId = builder.productId;
        this.favoriteDate = builder.favoriteDate;
    }

    public Favorite() {
    }

    public Long getFavoriteId() { return favoriteId; }
    public void setFavoriteId(Long favoriteId) { this.favoriteId = favoriteId; }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public Long getProductId() { return productId; }
    public void setProductId(Long productId) { this.productId = productId; }

    public Date getFavoriteDate() { return favoriteDate; }
    public void setFavoriteDate(Date favoriteDate) { this.favoriteDate = favoriteDate; }

    public static class Builder {
        private Long favoriteId;
        private Long userId;
        private Long productId;
        private Date favoriteDate;

        public Builder setFavoriteId(Long favoriteId) {
            this.favoriteId = favoriteId;
            return this;
        }
        public Builder setUserId(Long userId) {
            this.userId = userId;
            return this;
        }
        public Builder setProductId(Long productId) {
            this.productId = productId;
            return this;
        }
        public Builder setFavoriteDate(Date favoriteDate) {
            this.favoriteDate = favoriteDate;
            return this;
        }
        public Favorite build() {
            return new Favorite(this);
        }
    }
}
