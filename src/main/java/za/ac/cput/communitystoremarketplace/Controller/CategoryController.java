package za.ac.cput.communitystoremarketplace.Controller;

import org.springframework.web.bind.annotation.*;
import za.ac.cput.communitystoremarketplace.Domain.Category;
import za.ac.cput.communitystoremarketplace.Service.CategoryService;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping("/create")
    public Category create(@RequestBody Category category) {
        return categoryService.create(category);
    }

    @GetMapping("/read")
    public Category read(@RequestParam Long categoryId) {
        return categoryService.read(categoryId);
    }

    @PutMapping("/update")
    public Category update(@RequestBody Category category) {
        return categoryService.update(category);
    }

    @DeleteMapping("/delete")
    public boolean delete(@RequestParam Long categoryId) {
        return categoryService.delete(categoryId);
    }

    @GetMapping("/getAll")
    public List<Category> getAll() {
        return categoryService.getAll();
    }
}
