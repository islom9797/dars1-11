package org.islom.dars111.service;

import org.islom.dars111.entity.Measurement;
import org.islom.dars111.payload.Result;
import org.islom.dars111.repository.MeasurementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MeasurementService {
    @Autowired
    MeasurementRepository measurementRepository;

    public Result addMeasurement(Measurement measurement) {
        boolean existsByName = measurementRepository.existsByName(measurement.getName());
        if (existsByName) {
            return new Result("Bunday o'lchov birligi mavjud emas", false)
                    ;
        }

        measurementRepository.save(measurement);
        return new Result("muvaffaqiyatli saqlandi", true);

    }

    public List<Measurement> getAll() {
        return measurementRepository.findAll();
    }

    public Measurement getById(Integer id) {
        Optional<Measurement> byId = measurementRepository.findById(id);
        if (byId.isPresent()) {
            return byId.get();
        }
        return null;
    }

    public Result updateMeasurement(Measurement measurement) {
        Optional<Measurement> byId = measurementRepository.findById(measurement.getId());
        if (byId.isPresent()) {
            Measurement updatedMeasurement = byId.get();
            updatedMeasurement.setName(measurement.getName());
            updatedMeasurement.setActive(measurement.isActive());
            Measurement save = measurementRepository.save(updatedMeasurement);
            return new Result("muvaffaqiyatli yangilandi", true);

        }
        return new Result("Bunday Measurement mavjud emas", false);

    }

    public Result deleteMeasurement(Integer id) {
        Optional<Measurement> byId = measurementRepository.findById(id);
        if (byId.isPresent()) {
            measurementRepository.deleteById(id);
            return new Result("muvaffaqiyatli o'chirildi", true);
        }
        return new Result("Bunday o'lchov birligi mavjud emas", false);
    }
}
