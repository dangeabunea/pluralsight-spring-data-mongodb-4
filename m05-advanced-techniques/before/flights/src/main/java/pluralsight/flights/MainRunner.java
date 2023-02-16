package pluralsight.flights;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pluralsight.flights.dal.FlightPlanRepository;

/*
This component will be executed by Spring Framework immediately after application
bootstrap
 */
@Component
public class MainRunner implements CommandLineRunner {
    private FlightPlanRepository repository;

    public MainRunner(FlightPlanRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) throws Exception {

    }
}
