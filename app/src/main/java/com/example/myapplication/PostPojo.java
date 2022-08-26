package com.example.myapplication;

public class PostPojo {
        private float id;
        private String description;
        private String scheduledDate;
        private String status;


        // Getter Methods

        public float getId() {
            return id;
        }

        public String getDescription() {
            return description;
        }

        public String getScheduledDate() {
            return scheduledDate;
        }

        public String getStatus() {
            return status;
        }

        // Setter Methods

        public void setId(float id) {
            this.id = id;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public void setScheduledDate(String scheduledDate) {
            this.scheduledDate = scheduledDate;
        }

        public void setStatus(String status) {
            this.status = status;
        }
    }
