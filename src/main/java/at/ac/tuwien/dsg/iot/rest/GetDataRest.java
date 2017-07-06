package at.ac.tuwien.dsg.iot.rest;


import at.ac.tuwien.dsg.iot.model.*;
import at.ac.tuwien.dsg.iot.repository.MeasurementRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * REST interface to query the database.
 *
 * Created by jan on 29.06.17.
 */
@RestController
public class GetDataRest {

    private final Logger log = LoggerFactory.getLogger(this.getClass());


    @Autowired
    private MeasurementRepository repository;

    /**
     * Get the average temperature and number of saved datapoints for all
     * measurepoints.
     *
     * @return
     */
    @RequestMapping("average")
    public List<MeasurementAvg> getAverageAll(){
        log.info("getAverageAll: ");

        List<MeasurementAvg> measurementAvgs = new ArrayList<>();
        measurementAvgs.add(repository.getAvgMeasurement(MeasurePoint.MEASURE_POINT1));
        measurementAvgs.add(repository.getAvgMeasurement(MeasurePoint.MEASURE_POINT2));
        measurementAvgs.add(repository.getAvgMeasurement(MeasurePoint.MEASURE_POINT3));
        measurementAvgs.add(repository.getAvgMeasurement(MeasurePoint.MEASURE_POINT4));

        return measurementAvgs;
    }

    /**
     * Get average temperature and number of saved datapoints for a given measurepoint.
     *
     * @param measurePoint
     * @return
     */
    @RequestMapping("average/{measure_point}")
    public MeasurementAvg getAverage(@PathVariable("measure_point") MeasurePoint measurePoint){
        log.info("getAverage: "+measurePoint);
        return repository.getAvgMeasurement(measurePoint);
    }

    @RequestMapping("test")
    public String test(){
        log.info("test");

        MeasurementAvg test = repository.getAvgMeasurement(MeasurePoint.MEASURE_POINT1);
        log.info("test: "+test);

        return "Test: "+test;
    }

    /**
     * Get all saved measurement data.
     * @return
     */
    @RequestMapping("all")
    public List<Measurement> getAll(){
        log.info("get all measurement data");
        return repository.findAll();
    }
}
