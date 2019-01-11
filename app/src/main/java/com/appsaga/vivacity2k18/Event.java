package com.appsaga.vivacity2k18;

public class Event {

    int imageID;
    String title;
    String time;

    Event(int imageID,String title,String time){

        this.imageID=imageID;
        this.title=title;
        this.time=time;
    }

    public int getImageID() {
        return imageID;
    }

    public String getTitle() {
        return title;
    }

    public String getTime() {
        return time;
    }
}
