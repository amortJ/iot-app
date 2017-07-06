package at.ac.tuwien.dsg.iot.model;

/**
 * Created by jan on 06.07.17.
 */
public class MeasurementAvg {

    private long count; // number of measurements in db
    private double avg; // average temperature
    private MeasurePoint measurePoint;

    public MeasurementAvg() {
    }

    public MeasurementAvg(long count, double avg, MeasurePoint measurePoint) {
        this.count = count;
        this.avg = avg;
        this.measurePoint = measurePoint;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public double getAvg() {
        return avg;
    }

    public void setAvg(double avg) {
        this.avg = avg;
    }

    public MeasurePoint getMeasurePoint() {
        return measurePoint;
    }

    public void setMeasurePoint(MeasurePoint measurePoint) {
        this.measurePoint = measurePoint;
    }

    @Override
    public String toString() {
        return "MeasurementAvg{" +
                "count=" + count +
                ", avg=" + avg +
                ", measurePoint=" + measurePoint +
                '}';
    }
}
