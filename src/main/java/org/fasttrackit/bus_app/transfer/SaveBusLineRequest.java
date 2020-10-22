package org.fasttrackit.bus_app.transfer;

import javax.validation.constraints.NotNull;

public class SaveBusLineRequest {

    @NotNull
    private String name;

    @NotNull
    private String firstStation;

    @NotNull
    private String lastStation;

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
        return "SaveBusLineRequest{" +
                "name='" + name + '\'' +
                ", firstStation='" + firstStation + '\'' +
                ", lastStation='" + lastStation + '\'' +
                '}';
    }
}
