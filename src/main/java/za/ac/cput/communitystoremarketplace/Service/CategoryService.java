package za.ac.cput.communitystoremarketplace.Service;

import org.springframework.stereotype.Service;
import za.ac.cput.communitystoremarketplace.Domain.Category;
import za.ac.cput.communitystoremarketplace.Repository.CategoryRepository;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category create(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category read(Long categoryId) {
        return categoryRepository.findById(categoryId).orElse(null);
    }

    @Override
    public Category update(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public boolean delete(Long categoryId) {
        categoryRepository.deleteById(categoryId);
        return true;
    }
}
