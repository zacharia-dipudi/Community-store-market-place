package za.ac.cput.communitystoremarketplace.Service;

import za.ac.cput.communitystoremarketplace.Domain.Order;

import java.util.List;

public interface IOrderService extends IService<Order, Long>{
    List<Order>getAll();

    }

