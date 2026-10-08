package za.ac.cput.communitystoremarketplace.Controller;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.communitystoremarketplace.Domain.Announcement;
import za.ac.cput.communitystoremarketplace.Service.AnnouncementService;

import java.util.List;
public class AnnouncementController {
     private final AnnouncementService announcementService;

        AnnouncementController(AnnouncementService announcementService){
            this.announcementService=announcementService;
        }
        @PostMapping("/create")
        public Announcement create(@RequestBody Announcement announcement){
            return announcementService.create(announcement);
        }
        @GetMapping("/read")
        public Announcement read(@RequestParam Long announcementId){
            return announcementService.read(announcementId);
        }
        @PutMapping("/update")
        public Announcement update(@RequestBody Announcement announcement){
            return announcementService.update(announcement);
        }
        @DeleteMapping("/delete")
        public boolean delete(@RequestParam Long announcementId){
            return announcementService.delete(announcementId);
        }
        List<Announcement>getAll(){
            return announcementService.getAll();
        }
}
