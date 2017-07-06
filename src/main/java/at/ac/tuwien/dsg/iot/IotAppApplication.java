package at.ac.tuwien.dsg.iot;

import at.ac.tuwien.dsg.iot.repository.MeasurementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class IotAppApplication {

    @Autowired
    private MeasurementRepository repository;

	public static void main(String[] args) {

		// fixes a problem with the unik-framework
		String [] noargs = {};

		SpringApplication.run(IotAppApplication.class, noargs);

	}
}
