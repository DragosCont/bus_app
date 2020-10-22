package org.fasttrackit.bus_app.service;


import org.fasttrackit.bus_app.domain.BusLine;
import org.fasttrackit.bus_app.domain.Information;
import org.fasttrackit.bus_app.domain.User;
import org.fasttrackit.bus_app.exception.ResourceNotFoundException;
import org.fasttrackit.bus_app.persistence.InformationRepository;
import org.fasttrackit.bus_app.transfer.AddBusLineToInformationRequest;
import org.fasttrackit.bus_app.transfer.GetInformationsRequest;
import org.fasttrackit.bus_app.transfer.GetUsersRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class InformationService {

    private static final Logger LOGGER = LoggerFactory.getLogger(InformationService.class);

    private final InformationRepository informationRepository;
    private final BusLineService busLineService;

    @Autowired
    public InformationService(InformationRepository informationRepository, BusLineService busLineService) {
        this.informationRepository = informationRepository;
        this.busLineService = busLineService;
    }

    @Transactional
    public Information addBusLineToInformation(AddBusLineToInformationRequest request) {
        LOGGER.info("Adding BusLine to information: {}", request);

        Information information = informationRepository.findById(request.getBusLineId())
                .orElse(new Information());

        if (information.getBusLine() == null) {
            BusLine busLine = busLineService.getBusLine(request.getBusLineId());
            information.setBusLine(busLine);
        }

        // add busLine to information

        return informationRepository.save(information);
    }

    public Information getInformation(long busLineId) {
        LOGGER.info("Retrieving information for busLine {}", busLineId);

        Optional<Information> optional = informationRepository.findById(busLineId);

        if (optional.isPresent()) {
            return optional.get();
        } else {
            throw new ResourceNotFoundException("Information about busLine " + busLineId + " does not exist.");
        }

    }

    public Page<Information> getInformations(GetInformationsRequest request, Pageable pageable) {
        LOGGER.info("Retrieving informations: {}",request);

        return informationRepository.findByOptionalCriteria(request.getPartialRoute(), pageable);
    }

}
