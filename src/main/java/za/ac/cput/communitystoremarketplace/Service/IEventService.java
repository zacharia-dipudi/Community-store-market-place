package za.ac.cput.communitystoremarketplace.Service;

import za.ac.cput.communitystoremarketplace.Domain.Event;

import java.util.List;

public interface IEventService extends IService<Event, Long> {
    List<Event>getAll();
}
