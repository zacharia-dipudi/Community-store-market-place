package za.ac.cput.communitystoremarketplace.Service;

import za.ac.cput.communitystoremarketplace.Domain.Announcement;

import java.util.List;

public interface IAnnouncementService extends IService<Announcement, Long>{
    List<Announcement>getAll();
}

    

