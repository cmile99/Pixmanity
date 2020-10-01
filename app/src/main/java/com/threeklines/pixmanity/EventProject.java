package com.threeklines.pixmanity;

public class EventProject {
    private String eventName;
    private int eventImage;
    private String eventDate;

    public EventProject(String eventName, int eventImage, String eventDate) {
        this.eventName = eventName;
        this.eventImage = eventImage;
        this.eventDate = eventDate;
    }

    public String getEventName() {
        return eventName;
    }

    public int getEventImage() {
        return eventImage;
    }

    public String getEventDate() {
        return eventDate;
    }
}
