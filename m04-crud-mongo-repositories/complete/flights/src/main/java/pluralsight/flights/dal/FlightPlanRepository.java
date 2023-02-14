package pluralsight.flights.dal;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import pluralsight.flights.domain.FlightPlan;

import java.util.List;

public interface FlightPlanRepository extends MongoRepository<FlightPlan, String> {

    List<FlightPlan> findFlightPlansByIsInternationalTrueAndCrossedCountriesContaining(String country);

    @Query("{'isInternational' : true, 'crossedCountries' : { '$in' : [?0]}}")
    List<FlightPlan> findInternationalCrossing(String country);

    List<FlightPlan> findFlightPlansByFlightDurationBetween(int minDuration, int maxDuration, PageRequest pageRequest);
    List<FlightPlan> findFlightPlansByAircraftModelContainsOrderByAircraftSeatCapacityAsc(String aircraft);
}
