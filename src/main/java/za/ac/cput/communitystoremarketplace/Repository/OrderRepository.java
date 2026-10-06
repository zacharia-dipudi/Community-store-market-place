package za.ac.cput.communitystoremarketplace.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.communitystoremarketplace.Domain.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
