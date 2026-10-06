package za.ac.cput.communitystoremarketplace.Factory;

import za.ac.cput.communitystoremarketplace.Domain.Product;

public class ProductFactory {
    public static Product createProduct(Long productId, String productName,String productDescription,Double productPrice, int productQuantity, String productCondition){
        return new Product.Builder()
                .setProductId(productId)
                .setProductName(productName)
                .setProductDescription(productDescription)
                .setProductPrice(productPrice)
                .setProductQuantity(productQuantity)
                .setProductCondition(productCondition)
                .build();
    }
}
