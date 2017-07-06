package at.ac.tuwien.dsg.iot.collection;

import at.ac.tuwien.dsg.iot.model.MeasurePoint;
import at.ac.tuwien.dsg.iot.model.Measurement;
import at.ac.tuwien.dsg.iot.repository.MeasurementRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Generating simulated measurement data.
 *
 * Created by jan on 29.06.17.
 */
@Component
public class DataCollector {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private MeasurementRepository repository;

    @Scheduled(fixedRate = 3000) // 3 seconds
    public void collectDataMP1(){
        addData(MeasurePoint.MEASURE_POINT1);
    }

    @Scheduled(fixedRate = 4000) // 4 seconds
    public void collectDataMP2(){
        addData(MeasurePoint.MEASURE_POINT2);
    }

    @Scheduled(fixedRate = 3500) // 3,5 seconds
    public void collectDataMP3(){
        addData(MeasurePoint.MEASURE_POINT3);
    }

    @Scheduled(fixedRate = 4500) // 4,5 seconds
    public void collectDataMP4(){
        addData(MeasurePoint.MEASURE_POINT4);
    }

    public void addData(MeasurePoint measurePoint){

        double temperature = ((Math.random()*100)+10)%60;
        log.info("Measured: {} : {}", measurePoint, temperature);

        Measurement measurement = new Measurement(measurePoint, (new Date()).getTime(), temperature);
        repository.save(measurement);
    }
}
