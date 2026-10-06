package za.ac.cput.communitystoremarketplace.Factory;

import za.ac.cput.communitystoremarketplace.Domain.Product;
import za.ac.cput.communitystoremarketplace.util.Helper;

public class ProductFactory {
    public static Product createProduct(Long productId, String productName,String productDescription,Double productPrice, int productQuantity, String productCondition) {

        if (!Helper.isNullorEmpty(productName)
                && !Helper.isNullorEmpty(productDescription)
                && !Helper.isNullorEmpty(productCondition)) {

            return new Product.Builder()
                    .setProductId(productId)
                    .setProductName(productName)
                    .setProductDescription(productDescription)
                    .setProductPrice(productPrice)
                    .setProductQuantity(productQuantity)
                    .setProductCondition(productCondition)
                    .build();
        }
        return null;
    }

}
