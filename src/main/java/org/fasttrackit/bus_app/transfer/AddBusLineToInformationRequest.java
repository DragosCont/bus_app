package org.fasttrackit.bus_app.transfer;

import javax.validation.constraints.NotNull;

public class AddBusLineToInformationRequest {

    @NotNull
    private Long busLineId;

    @NotNull
    private Long informationId;

    public Long getBusLineId() {
        return busLineId;
    }

    public void setBusLineId(Long busLineId) {
        this.busLineId = busLineId;
    }

    public Long getInformationId() {
        return informationId;
    }

    public void setInformationId(Long informationId) {
        this.informationId = informationId;
    }

    @Override
    public String toString() {
        return "AddBusLineToInformationRequest{" +
                "busLineId=" + busLineId +
                ", informationId=" + informationId +
                '}';
    }
}
