package za.ac.cput.communitystoremarketplace.Service;

import za.ac.cput.communitystoremarketplace.Domain.Category;

import java.util.List;

public interface ICategoryService extends IService<Category, Long> {
    List<Category> getAll();
}
