package pluralsight.flights;

import org.springframework.boot.CommandLineRunner;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;
import pluralsight.flights.dal.FlightPlanDataService;
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
    private FlightPlanDataService flightPlanDataService;

    public MainRunner(FlightPlanDataService flightPlanDataService) {
        this.flightPlanDataService = flightPlanDataService;
    }

    @Override
    public void run(String... args) throws Exception {
        // create
        this.flightPlanDataService.insertInitialFlightPlans();

        // read (query)
        //System.out.println(this.flightPlanDataService.findById("63e383b9b64a16763c50e5c8"));
        //System.out.println(this.flightPlanDataService.findInternationalCrossingFrance());
        //System.out.println(this.flightPlanDataService.findFirstTwoFlightsWhichLastBetweenOneAndThreeHours());
        //System.out.println(this.flightPlanDataService.findBoeingFlightsAndOrderBySeatCapacity());
        //System.out.println(this.flightPlanDataService.findByFullTextSearch("France"));

        // update

        /*
        this.flightPlanDataService.incrementDepartureTime(
                "63e383b9b64a16763c50e5c8",
                LocalDateTime.of(2024,1,1,20,0)
        );
         */

        //this.flightPlanDataService.changeDurationForFlightsInParis(100);

        // delete
        //flightPlanDataService.deleteById("63e383b9b64a16763c50e5c8");
        //flightPlanDataService.deleteAllFromParis();
        //flightPlanDataService.deleteAll();
    }


}
