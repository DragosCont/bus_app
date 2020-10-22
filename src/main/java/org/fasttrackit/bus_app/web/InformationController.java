package org.fasttrackit.bus_app.web;


import org.fasttrackit.bus_app.domain.Information;
import org.fasttrackit.bus_app.domain.User;
import org.fasttrackit.bus_app.service.InformationService;
import org.fasttrackit.bus_app.transfer.AddBusLineToInformationRequest;
import org.fasttrackit.bus_app.transfer.GetInformationsRequest;
import org.fasttrackit.bus_app.transfer.GetUsersRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/informations")
public class InformationController {

    private final InformationService informationService;

    @Autowired
    public InformationController(InformationService informationService) {
        this.informationService = informationService;
    }

    @PutMapping
    public ResponseEntity<Information> addBusLineToInformation(@RequestBody @Valid AddBusLineToInformationRequest request) {
        Information information = informationService.addBusLineToInformation(request);
        return ResponseEntity.ok(information);
    }

    @GetMapping("/{busLineId}")
    public ResponseEntity<Information> getInformation(@PathVariable long busLineId) {
        Information information = informationService.getInformation(busLineId);

        return ResponseEntity.ok(information);
    }

    @GetMapping
    public ResponseEntity<Page<Information>> getInformations(GetInformationsRequest request, Pageable pageable) {
        Page<Information> informations = informationService.getInformations(request, pageable);

        return ResponseEntity.ok(informations);
    }
}
