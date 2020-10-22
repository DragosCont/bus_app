package org.fasttrackit.bus_app.service;

import org.fasttrackit.bus_app.domain.BusLine;
import org.fasttrackit.bus_app.exception.ResourceNotFoundException;
import org.fasttrackit.bus_app.persistence.BusLineRepository;
import org.fasttrackit.bus_app.transfer.SaveBusLineRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BusLineService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    private final BusLineRepository busLineRepository;

    @Autowired
    public BusLineService(BusLineRepository busLineRepository) {
        this.busLineRepository = busLineRepository;
    }

    public BusLine createBusLine(SaveBusLineRequest request) {
        LOGGER.info("Creating busLine: {}", request);

        BusLine busLine = new BusLine();
        busLine.setName(request.getName());
        busLine.setFirstStation(request.getFirstStation());
        busLine.setLastStation(request.getLastStation());

        return busLineRepository.save(busLine);
    }

    public BusLine getBusLine(long id) {
        LOGGER.info("Retrieving busLine {}", id);

        return busLineRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("BusLine " + id + " does not exist"));

    }

    public BusLine updateBusLine(long id, SaveBusLineRequest request) {
        LOGGER.info("Updating busLine {}: {}", id, request);

        BusLine existingBusLine = getBusLine(id);

        BeanUtils.copyProperties(request,existingBusLine);

        return busLineRepository.save(existingBusLine);
    }

    public void deleteBusLine(long id) {
        LOGGER.info("Deleting busLine {}", id);

        busLineRepository.deleteById(id);
    }
}
