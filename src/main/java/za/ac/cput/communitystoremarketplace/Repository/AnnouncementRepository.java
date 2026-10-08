package za.ac.cput.communitystoremarketplace.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.communitystoremarketplace.Domain.Announcement;

public interface AnnouncementRepository extends JpaRepository<Announcement, Long> {

}
