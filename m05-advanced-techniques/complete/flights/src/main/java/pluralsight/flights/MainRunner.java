package pluralsight.flights;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pluralsight.flights.dal.FlightPlanDataService;
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
    private FlightPlanRepository repository;

    public MainRunner(FlightPlanRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) throws Exception {
        repository.deleteAll();
        repository.insert(new FlightPlan(
                "Paris",
                "London",
                LocalDateTime.of(2023, 6, 1, 20, 15),
                60 * 90,
                List.of("France", "England"),
                true,
                AircraftFactory.buildBoeing737()
        ));

        System.out.println(this.repository.findAll());
    }
}
