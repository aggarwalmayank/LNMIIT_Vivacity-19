package com.appsaga.vivacity2k18;

public class EventDetail {

    private String Time;
    private String Venue;
    private String Day;
    private String Name;
    private String Parent;

    public EventDetail() {
    }


    public EventDetail(String time, String venue, String day, String parent, String name) {
        this.Time = time;
        this.Venue = venue;
        this.Day = day;
        this.Parent=parent;
        this.Name=name;

    }

    public String getTime() {
        return Time;
    }

    public String getVenue() {
        return Venue;
    }

    public String getDay() {
        return Day;
    }
    public String getName() {
        return Name;
    }

    public String getParent() {
        return Parent;
    }

}
