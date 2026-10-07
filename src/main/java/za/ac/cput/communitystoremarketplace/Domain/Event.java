package za.ac.cput.communitystoremarketplace.Domain;

import java.sql.Time;
import java.util.Date;



    public class Event {
        private Long eventId;
        private String eventTitle;
        private String eventDescription;
        private Date eventDate;
        private Time eventTime;
        private String eventLocation;

        public Event(Long eventId, String eventTitle, String eventDescription, Date eventDate, Time eventTime, String eventLocation) {
            this.eventId = eventId;
            this.eventTitle = eventTitle;
            this.eventDescription = eventDescription;
            this.eventDate = eventDate;
            this.eventTime = eventTime;
            this.eventLocation = eventLocation;

        }

        private Event(Builder builder) {
            this.eventId = builder.eventId;
            this.eventTitle = builder.eventTitle;
            this.eventDescription = builder.eventDescription;
            this.eventDate = builder.eventDate;
            this.eventTime = builder.eventTime;
            this.eventLocation = builder.eventLocation;
        }

        public Event() {
        }

        public Long getEventId() {
            return eventId;
        }

        public void setEventId(Long eventId) {
            this.eventId = eventId;
        }

        public String getEventLocation() {
            return eventLocation;
        }

        public void setEventLocation(String eventLocation) {
            this.eventLocation = eventLocation;
        }

        public Time getEventTime() {
            return eventTime;
        }

        public void setEventTime(Time eventTime) {
            this.eventTime = eventTime;
        }

        public Date getEventDate() {
            return eventDate;
        }

        public void setEventDate(Date eventDate) {
            this.eventDate = eventDate;
        }

        public String getEventDescription() {
            return eventDescription;
        }

        public void setEventDescription(String eventDescription) {
            this.eventDescription = eventDescription;
        }

        public String getEventTitle() {
            return eventTitle;
        }

        public void setEventTitle(String eventTitle) {
            this.eventTitle = eventTitle;
        }

        public static class Builder {
            private Long eventId;
            private String eventTitle;
            private String eventDescription;
            private Date eventDate;
            private Time eventTime;
            private String eventLocation;

            public Builder setEventId(Long eventId) {
                this.eventId = eventId;
                return this;
            }

            public Builder setEventTitle(String eventTitle) {
                this.eventTitle = eventTitle;
                return this;
            }

            public Builder setEventDescription(String eventDescription) {
                this.eventDescription = eventDescription;
                return this;
            }

            public Builder setEventDate(Date eventDate) {
                this.eventDate = eventDate;
                return this;
            }

            public Builder setEventTime(Time eventTime) {
                this.eventTime = eventTime;
                return this;
            }

            public Builder setEventLocation(String eventLocation) {
                this.eventLocation = eventLocation;
                return this;
            }

            public Event build() {
                return new Event(this);
            }
        }
    }
