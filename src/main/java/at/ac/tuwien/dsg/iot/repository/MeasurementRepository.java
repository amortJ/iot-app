package at.ac.tuwien.dsg.iot.repository;

import at.ac.tuwien.dsg.iot.model.MeasurePoint;
import at.ac.tuwien.dsg.iot.model.Measurement;
import at.ac.tuwien.dsg.iot.model.MeasurementAvg;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Repository to save and receive measurement data.
 *
 * Created by jan on 06.07.17.
 */
public interface MeasurementRepository extends CrudRepository<Measurement, Long> {

    List<Measurement> findAll();

    @Query(value = "select new at.ac.tuwien.dsg.iot.model.MeasurementAvg(count(m), avg(m.value), m.measurePoint) from Measurement m where m.measurePoint = ?1")
    MeasurementAvg getAvgMeasurement(MeasurePoint measurePoint);

}
