package za.ac.cput.communitystoremarketplace.Domain;

import jakarta.persistence.*;

@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId;
    private String categoryName;
    private String categoryDescription;

    public Category(Long categoryId, String categoryName, String categoryDescription) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.categoryDescription = categoryDescription;
    }

    private Category(Builder builder) {
        this.categoryId = builder.categoryId;
        this.categoryName = builder.categoryName;
        this.categoryDescription = builder.categoryDescription;
    }

    public Category() {
    }

    public Long getCategoryId() { return categoryId; }
    public void setCategoryId(Long categoryId) { this.categoryId = categoryId; }

    public String getCategoryName() { return categoryName; }
    public void setCategoryName(String categoryName) { this.categoryName = categoryName; }

    public String getCategoryDescription() { return categoryDescription; }
    public void setCategoryDescription(String categoryDescription) { this.categoryDescription = categoryDescription; }

    public static class Builder {
        private Long categoryId;
        private String categoryName;
        private String categoryDescription;

        public Builder setCategoryId(Long categoryId) {
            this.categoryId = categoryId;
            return this;
        }
        public Builder setCategoryName(String categoryName) {
            this.categoryName = categoryName;
            return this;
        }
        public Builder setCategoryDescription(String categoryDescription) {
            this.categoryDescription = categoryDescription;
            return this;
        }
        public Category build() {
            return new Category(this);
        }
    }
}
