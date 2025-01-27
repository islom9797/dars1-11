package org.islom.dars111.controller;

import org.islom.dars111.entity.Measurement;
import org.islom.dars111.payload.Result;
import org.islom.dars111.repository.MeasurementRepository;
import org.islom.dars111.service.MeasurementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/measurement")
public class MeasurementController {

    @Autowired
    MeasurementService measurementService;

    @PostMapping
    private Result addMeasurement(@RequestBody Measurement measurement) {
        Result result = measurementService.addMeasurement(measurement);
        return result;
    }

    @GetMapping
    private List<Measurement> getAll() {
        return measurementService.getAll();
    }

    @GetMapping("/{id}")
    private Measurement getMeasurementById(@PathVariable Integer id) {
        return measurementService.getById(id);
    }

    @DeleteMapping
    private Result deleteMeasurement(@PathVariable Integer id) {

        return measurementService.deleteMeasurement(id);
    }

    @PutMapping
    private Result updateMeasurement(@RequestBody Measurement measurement) {
        return measurementService.updateMeasurement(measurement);
    }
}
