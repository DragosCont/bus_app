package org.fasttrackit.bus_app.domain;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class BusLine {

    @Id
    private long id;

    @NotNull
    private String name;

    @NotNull
    private String firstStation;

    @NotNull
    private String lastStation;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstStation() {
        return firstStation;
    }

    public void setFirstStation(String firstStation) {
        this.firstStation = firstStation;
    }

    public String getLastStation() {
        return lastStation;
    }

    public void setLastStation(String lastStation) {
        this.lastStation = lastStation;
    }

    @Override
    public String toString() {
        return "BusLine{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", firstStation='" + firstStation + '\'' +
                ", lastStation='" + lastStation + '\'' +
                '}';
    }
}
