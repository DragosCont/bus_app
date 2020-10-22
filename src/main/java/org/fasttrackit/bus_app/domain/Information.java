package org.fasttrackit.bus_app.domain;


import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Information {

    @Id
    private long id;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private BusLine busLine;

//    @OneToOne(fetch = FetchType.LAZY)
//    @MapsId
//    private User user;

    @NotNull
    private String timetable;

    @NotNull
    private String route;

    private String mapUrl;

    public String getTimetable() {
        return timetable;
    }

    public void setTimetable(String timetable) {
        this.timetable = timetable;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public String getMapUrl() {
        return mapUrl;
    }

    public void setMapUrl(String mapUrl) {
        this.mapUrl = mapUrl;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public BusLine getBusLine() {
        return busLine;
    }

    public void setBusLine(BusLine busLine) {
        this.busLine = busLine;
    }

//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }

    @Override
    public String toString() {
        return "Information{" +
                "id=" + id +
                ", timetable='" + timetable + '\'' +
                ", route='" + route + '\'' +
                ", mapUrl='" + mapUrl + '\'' +
                '}';
    }
}
