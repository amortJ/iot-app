package at.ac.tuwien.dsg.iot.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by jan on 06.07.17.
 */
@Entity
@Table(name = "Measurement")
public class Measurement {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    private MeasurePoint measurePoint;
    private long timestamp;
    private double value;

    protected Measurement() {
    }

    public Measurement(MeasurePoint measurePoint, long timestamp, double value) {
        this.measurePoint = measurePoint;
        this.timestamp = timestamp;
        this.value = value;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MeasurePoint getMeasurePoint() {
        return measurePoint;
    }

    public void setMeasurePoint(MeasurePoint measurePoint) {
        this.measurePoint = measurePoint;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
