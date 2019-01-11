package com.appsaga.vivacity2k18;

public class AllEventDetails {

    int imageID;
    String event;

    AllEventDetails(String event,int imageID ) {

        this.imageID = imageID;
        this.event=event;
    }

    public int getImageID() {
        return imageID;
    }

    public String getEvent() {
        return event;
    }
}
