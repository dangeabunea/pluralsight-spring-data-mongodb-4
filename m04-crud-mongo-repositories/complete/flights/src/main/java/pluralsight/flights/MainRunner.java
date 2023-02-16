package pluralsight.flights;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pluralsight.flights.dal.FlightPlanDataService;

import java.time.LocalDateTime;

/*
This component will be executed by Spring Framework immediately after application
bootstrap
 */
@Component
public class MainRunner implements CommandLineRunner {
    private FlightPlanDataService flightPlanDataService;

    public MainRunner(@Qualifier("flightPlanRepositoryDataService") FlightPlanDataService flightPlanDataService) {
        this.flightPlanDataService = flightPlanDataService;
    }

    @Override
    public void run(String... args) throws Exception {
        // CRETE

        // flightPlanDataService.insertInitialFlightPlans();

        // READ
        //System.out.println(this.flightPlanDataService.findById("ID_HERE"));
        //System.out.println(this.flightPlanDataService.findInternationalCrossingFrance());
        //System.out.println(this.flightPlanDataService.findFirstTwoFlightsWhichLastBetweenOneAndThreeHours());
        //System.out.println(this.flightPlanDataService.findBoeingFlightsAndOrderBySeatCapacity());
        //System.out.println(this.flightPlanDataService.findByFullTextSearch("Paris"));

        // UPDATE
        // this.flightPlanDataService.incrementDepartureTime("ID_HERE", LocalDateTime.now());
        // this.flightPlanDataService.changeDurationForFlightsInParis(100);

        // DELETE
        //this.flightPlanDataService.deleteById("ID_HERE");
        //this.flightPlanDataService.deleteAllFromParis();
        //this.flightPlanDataService.deleteAll();
    }
}
