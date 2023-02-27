package pluralsight.flights;

import org.springframework.boot.CommandLineRunner;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;
import pluralsight.flights.dal.FlightPlanRepository;
import pluralsight.flights.domain.Address;
import pluralsight.flights.domain.Airport;

/*
This component will be executed by Spring Framework immediately after application
bootstrap
 */
@Component
public class MainRunner implements CommandLineRunner {
    private FlightPlanRepository repository;
    private MongoTemplate mongoTemplate;

    public MainRunner(FlightPlanRepository repository, MongoTemplate mongoTemplate) {
        this.repository = repository;
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public void run(String... args) throws Exception {
        var addr = new Address();
        mongoTemplate.save(addr);

        var a = new Airport("Otopeni", "LROP", 2, true);
        a.setAddress(addr);

        mongoTemplate.save(a);
    }
}
