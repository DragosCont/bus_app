package org.fasttrackit.bus_app.transfer;

public class GetInformationsRequest {

    private String partialRoute;

    public String getPartialRoute() {
        return partialRoute;
    }

    public void setPartialRoute(String partialRoute) {
        this.partialRoute = partialRoute;
    }

    @Override
    public String toString() {
        return "GetInformationsRequest{" +
                "partialRoute='" + partialRoute + '\'' +
                '}';
    }
}
