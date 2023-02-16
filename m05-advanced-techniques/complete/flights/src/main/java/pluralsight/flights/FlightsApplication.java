package pluralsight.flights;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.convert.MongoCustomConversions;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import pluralsight.flights.dal.converters.FlightPlanReadConverter;
import pluralsight.flights.dal.converters.FlightPlanWriteConverter;

import java.util.ArrayList;

@SpringBootApplication
@EnableMongoRepositories(basePackages = "pluralsight.flights.dal")
public class FlightsApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlightsApplication.class, args);
	}

	@Bean
	public MongoCustomConversions mongoCustomConversions() {
		var list = new ArrayList<>();
		// list.add(new FlightPlanReadConverter());
		// list.add(new FlightPlanWriteConverter());
		return new MongoCustomConversions(list);
	}
}
