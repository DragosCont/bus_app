package org.fasttrackit.bus_app.web;


import org.fasttrackit.bus_app.domain.BusLine;
import org.fasttrackit.bus_app.service.BusLineService;
import org.fasttrackit.bus_app.transfer.SaveBusLineRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/busLines")
public class BusLineController {

    private final BusLineService busLineService;

    @Autowired
    public BusLineController(BusLineService busLineService) {
        this.busLineService = busLineService;
    }


    @PostMapping
    public ResponseEntity<BusLine> createBusLine(@RequestBody @Valid SaveBusLineRequest request) {
        BusLine busLine = busLineService.createBusLine(request);

        return new ResponseEntity<>(busLine, HttpStatus.CREATED);

    }

    @GetMapping("/{id}")
    public ResponseEntity<BusLine> getBusLine(@PathVariable long id) {
        BusLine busLine = busLineService.getBusLine(id);

        return ResponseEntity.ok(busLine);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BusLine> updateBusLine(@PathVariable long id, @RequestBody @Valid SaveBusLineRequest request) {
        BusLine busLine = busLineService.updateBusLine(id, request);

        return ResponseEntity.ok(busLine);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBusLine(@PathVariable long id) {
        busLineService.deleteBusLine(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
