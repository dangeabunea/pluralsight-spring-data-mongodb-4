package pluralsight.flights;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pluralsight.flights.dal.AircraftRepository;
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
    private AircraftRepository aircraftRepository;

    public MainRunner(FlightPlanRepository repository, AircraftRepository aircraftRepository) {
        this.flightPlanRepository = repository;
        this.aircraftRepository = aircraftRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        aircraftRepository.deleteAll();
        flightPlanRepository.deleteAll();

        flightPlanRepository.insert(new FlightPlan(
                "Vienna",
                "Bucharest",
                LocalDateTime.of(2023, 5, 1, 20, 15),
                60 * 70,
                List.of("Austria", "Hngary", "Romania"),
                true,
                AircraftFactory.buildEmbraerE175()
        ));
    }
}
