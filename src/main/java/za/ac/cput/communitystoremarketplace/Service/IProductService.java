package za.ac.cput.communitystoremarketplace.Service;

import za.ac.cput.communitystoremarketplace.Domain.Product;

import java.util.List;

public interface IProductService extends IService<Product, Long>{
    List<Product>getAll();
}
