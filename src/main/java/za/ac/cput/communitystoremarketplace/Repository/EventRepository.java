package za.ac.cput.communitystoremarketplace.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.communitystoremarketplace.Domain.Event;

public interface EventRepository extends JpaRepository<Event, Long> {
}
