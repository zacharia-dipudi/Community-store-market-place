package za.ac.cput.communitystoremarketplace.Factory;

import za.ac.cput.communitystoremarketplace.Domain.Category;
import za.ac.cput.communitystoremarketplace.util.Helper;

public class CategoryFactory {
    public static Category createCategory(Long categoryId, String categoryName, String categoryDescription) {

        if (!Helper.isNullorEmpty(categoryName)
                && !Helper.isNullorEmpty(categoryDescription)) {

            return new Category.Builder()
                    .setCategoryId(categoryId)
                    .setCategoryName(categoryName)
                    .setCategoryDescription(categoryDescription)
                    .build();
        }
        return null;
    }
}
