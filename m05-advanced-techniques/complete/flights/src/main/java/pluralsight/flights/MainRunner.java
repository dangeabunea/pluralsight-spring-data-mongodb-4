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

        var a350 = aircraftRepository.insert(AircraftFactory.buildAirbusA350());
        var b747 = aircraftRepository.insert(AircraftFactory.buildBoeing747());

        flightPlanRepository.insert(new FlightPlan(
                "Paris",
                "London",
                LocalDateTime.of(2023, 6, 1, 20, 15),
                60 * 90,
                List.of("France", "England"),
                true,
                a350
        ));

        System.out.println(this.flightPlanRepository.findAll());
    }
}
