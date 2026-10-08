
package za.ac.cput.communitystoremarketplace.Factory;

import java.time.LocalDateTime;
import za.ac.cput.communitystoremarketplace.Domain.Announcement;
import za.ac.cput.communitystoremarketplace.util.Helper;

public class AnnouncementFactory {

    public static Announcement createAnnouncement(
            Long announcementId,
            String title,
            String message,
            Long createdBy,
            LocalDateTime createdDate,
            LocalDateTime expiryDate,
            String status,
            String priority) {

        if (announcementId != null
                && !Helper.isNullorEmpty(title)
                && !Helper.isNullorEmpty(message)
                && createdBy != null
                && createdDate != null
                && expiryDate != null
                && !Helper.isNullorEmpty(status)
                && !Helper.isNullorEmpty(priority)) {

            return new Announcement.Builder()
                    .setAnnouncementId(announcementId)
                    .setTitle(title)
                    .setMessage(message)
                    .setCreatedBy(createdBy)
                    .setCreatedDate(createdDate)
                    .setExpiryDate(expiryDate)
                    .setStatus(status)
                    .setPriority(priority)
                    .build();
        }

        return null;
    }
}

