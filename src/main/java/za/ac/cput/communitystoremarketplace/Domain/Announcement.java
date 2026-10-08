package za.ac.cput.communitystoremarketplace.Domain;
import java.time.LocalDateTime;

public class Announcement {
    private Long announcementId;
    private String title;
    private String message;
    private Long createdBy;
    private LocalDateTime createdDate;
    private LocalDateTime expiryDate;
    private String status;
    private String priority;
    
    
    public Announcement(Long announcementId, String title, String message, Long createdBy, LocalDateTime createdDate, LocalDateTime expiryDate, String status, String priority){
        this.announcementId = announcementId; 
        this.title = title;
        this.message= message;
        this.createdBy= createdBy;
        this.createdDate= createdDate;
        this.expiryDate= expiryDate;
        this.status= status;
        this.priority= priority;
        
    }
    
    public Announcement(Builder builder){
        this.announcementId = builder.announcementId; 
        this.title = builder.title;
        this.message= builder.message;
        this.createdBy= builder.createdBy;
        this.createdDate= builder.createdDate;
        this.expiryDate= builder.expiryDate;
        this.status= builder.status;
        this.priority= builder.priority;
    }

    public Long getAnnouncementId() {
        return announcementId;
    }

    public String getTitle() {
        return title;
    }

    public String getMessage() {
        return message;
    }

    public Long getCreatedBy() {
        return createdBy;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public LocalDateTime getExpiryDate() {
        return expiryDate;
    }

    public String getStatus() {
        return status;
    }

    public String getPriority() {
        return priority;
    }

    public void setAnnouncementId(Long announcementId) {
        this.announcementId = announcementId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public void setExpiryDate(LocalDateTime expiryDate) {
        this.expiryDate = expiryDate;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }
    
     public static class Builder{
        private Long announcementId;
        private String title;
        private String message;
        private Long createdBy;
        private LocalDateTime createdDate;
        private LocalDateTime expiryDate;
        private String status;
        private String priority;
    
    
     public Builder setAnnouncementId(Long announcementId){
            this.announcementId=announcementId;
            return this;
        }
     
     public Builder setTitle(String title){
         this.title= title;
         return this;
     }
     
     public Builder setMesage(String message){
         this.message= message;
         return this;
     }
     
     public Builder setCreatedBy(Long createdBy){
         this.createdBy= createdBy;
         return this;
     }
     
     public Builder setCreatedDate(LocalDateTime createdDate){
         this.createdDate= createdDate;
         return this;
         }
     
     public Builder setExpiryDate(LocalDateTime expiryDate){
         this.expiryDate= expiryDate;
         return this;
     }
     
     public Builder setStatus( String status){
         this.status = status;
         return this;
     }
     
  
     
     public Announcement build(){
         return new Announcement(this);
     }
     }
    
}
