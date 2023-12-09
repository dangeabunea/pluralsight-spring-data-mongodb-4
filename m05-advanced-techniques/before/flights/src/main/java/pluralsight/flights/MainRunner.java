package pluralsight.flights;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pluralsight.flights.dal.FlightPlanRepository;
import pluralsight.flights.domain.AircraftFactory;
import pluralsight.flights.domain.FlightPlan;

import java.time.LocalDateTime;
import java.util.List;

/*
This component will be executed by Spring Framework immediately after application
bootstrap
 */
@Component
public class MainRunner implements CommandLineRunner {
    private FlightPlanRepository flightPlanRepository;

    public MainRunner(FlightPlanRepository flightPlanRepository) {
        this.flightPlanRepository = flightPlanRepository;
    }

    @Override
    public void run(String... args) throws Exception {

    }
}
