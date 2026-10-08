package za.ac.cput.communitystoremarketplace.Service;
import za.ac.cput.communitystoremarketplace.Domain.Announcement;
import za.ac.cput.communitystoremarketplace.Repository.AnnouncementRepository;

import java.util.List;

public class AnnouncementService implements IAnnouncementService{
        private final AnnouncementRepository announcementRepository;

    AnnouncementService(AnnouncementRepository announcementRepository) {
        this.announcementRepository = announcementRepository;
    }

    @Override
    public List<Announcement> getAll() {
        return List.of();
    }

    @Override
    public Announcement create(Announcement announcement) {
        return announcementRepository.save(announcement);
    }

    @Override
    public Announcement read(Long announcementId) {
        return announcementRepository.findById(announcementId).orElse(null);
    }

    @Override
    public Announcement update(Announcement announcement) {
        return announcementRepository.save(announcement);
    }

    @Override
    public boolean delete(Long announcementId) {
        announcementRepository.deleteById(announcementId);
        return true;
    }
}
