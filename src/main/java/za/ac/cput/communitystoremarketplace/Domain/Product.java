package za.ac.cput.communitystoremarketplace.Domain;

public class Product {
    private Long productId;
    private String productName;
    private String productDescription;
    private Double productPrice;
    private int productQuantity;
    private  String productCondition;

    public Product(Long productId, String productName,String productDescription,Double productPrice, int productQuantity, String productCondition){
        this.productId=productId;
        this.productName=productName;
        this.productDescription=productDescription;
        this.productPrice=productPrice;
        this.productQuantity=productQuantity;
        this.productCondition=productCondition;
    }
    private Product(Builder builder){
        this.productId=builder.productId;
        this.productName=builder.productName;
        this.productDescription=builder.productDescription;
        this.productPrice=builder.productPrice;
        this.productQuantity=builder.productQuantity;
        this.productCondition=builder.productCondition;
    }
    public Product(){
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductCondition() {
        return productCondition;
    }

    public void setProductCondition(String productCondition) {
        this.productCondition = productCondition;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public static class Builder{
        private Long productId;
        private String productName;
        private String productDescription;
        private Double productPrice;
        private int productQuantity;
        private  String productCondition;

        public Builder setProductId(Long productId){
            this.productId=productId;
            return this;
        }
        public Builder setProductName(String productName){
            this.productName=productName;
            return this;
        }
        public Builder setProductDescription(String productDescription){
            this.productCondition=productDescription;
            return this;
        }
        public Builder setProductPrice(Double productPrice){
            this.productPrice=productPrice;
            return this;
        }
        public Builder setProductQuantity(int productQuantity){
            this.productQuantity=productQuantity;
            return this;
        }
        public Builder setProductCondition(String productCondition){
            this.productCondition=productCondition;
            return this;
        }

        public Product build(){
            return new Product(this);
        }

    }


}
