package pluralsight.flights.dal;

import pluralsight.flights.domain.FlightPlan;

import java.time.LocalDateTime;
import java.util.List;

public interface FlightPlanDataService {
    void insertInitialFlightPlans();

    FlightPlan findById(String id);

    List<FlightPlan> findInternationalCrossingFrance();

    List<FlightPlan> findFirstTwoFlightsWhichLastBetweenOneAndThreeHours();

    List<FlightPlan> findBoeingFlightsAndOrderBySeatCapacity();

    List<FlightPlan> findByFullTextSearch(String value);

    void incrementDepartureTime(String id, LocalDateTime newDepartureTime);

    void changeDurationForFlightsInParis(int minutesToAdd);

    void deleteById(String id);

    void deleteAllFromParis();

    void deleteAll();
}
