package za.ac.cput.communitystoremarketplace.Controller;

import org.springframework.web.bind.annotation.*;
import za.ac.cput.communitystoremarketplace.Domain.Event;
import za.ac.cput.communitystoremarketplace.Service.EventService;

import java.util.List;

public class EventControl {
    private final EventService eventService;

    EventControl(EventService eventService){
        this.eventService=eventService;
    }
    @PostMapping("/create")
    public Event create(@RequestBody Event event){
        return eventService.create(event);
    }
    @GetMapping("/read")
    public Event read(@RequestParam Long eventId){
        return eventService.read(eventId);
    }
    @PutMapping("/update")
    public Event update(@RequestBody Event event){
        return eventService.update(event);
    }
    @DeleteMapping("/delete")
    public boolean delete(@RequestParam Long eventId){
        return eventService.delete(eventId);

    }

    List<Event>getAll(){
        return eventService.getAll();
    }

}
