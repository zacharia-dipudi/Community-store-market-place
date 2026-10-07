package za.ac.cput.communitystoremarketplace.Service;

import za.ac.cput.communitystoremarketplace.Domain.Event;
import za.ac.cput.communitystoremarketplace.Repository.EventRepository;

import java.util.List;

public class EventService implements IEventService{

    private final EventRepository eventRepository;

    EventService(EventRepository eventRepository){
        this.eventRepository=eventRepository;
    }
    @Override
    public List<Event> getAll() {
        return List.of();
    }

    @Override
    public Event create(Event event) {
        return eventRepository.save(event);
    }

    @Override
    public Event read(Long eventId) {
        return eventRepository.findById(eventId).orElse(null);
    }

    @Override
    public Event update(Event event) {
        return eventRepository.save(event);
    }

    @Override
    public boolean delete(Long eventId) {
        eventRepository.deleteById(eventId);
        return true;
    }
}
