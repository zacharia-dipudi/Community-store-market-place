package za.ac.cput.communitystoremarketplace.Service;

import za.ac.cput.communitystoremarketplace.Domain.Product;
import za.ac.cput.communitystoremarketplace.Repository.ProductRepository;

import java.util.List;

public class ProductService implements IProductService {

    private final ProductRepository productRepository;

    ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getAll() {
        return List.of();
    }

    @Override
    public Product create(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product read(Long productId) {
        return productRepository.findById(productId).orElse(null);
    }

    @Override
    public Product update(Product product) {
        return productRepository.save(product);
    }

    @Override
    public boolean delete(Long productId) {
        productRepository.deleteById(productId);
        return true;
    }
}
