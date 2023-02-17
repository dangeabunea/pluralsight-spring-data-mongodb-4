package pluralsight.flights.dal;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.mongodb.repository.Update;
import pluralsight.flights.domain.FlightPlan;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface FlightPlanRepository extends ReactiveMongoRepository<FlightPlan, String> {

    Flux<FlightPlan> findFlightPlansByIsInternationalTrueAndCrossedCountriesContaining(String country);

    @Query("{'isInternational' : true, 'crossedCountries' : { '$in' : [?0]}}")
    Flux<FlightPlan> findInternationalCrossing(String country);

    Flux<FlightPlan> findFlightPlansByFlightDurationBetween(int minDuration, int maxDuration, PageRequest pageRequest);
    Flux<FlightPlan> findFlightPlansByAircraftModelContainsOrderByAircraftSeatCapacityAsc(String aircraft);

    Flux<FlightPlan> findAllBy(TextCriteria criteria);

    @Update("{ '$inc' : { 'flightDuration' : ?1 } }")
    Mono<Void> findAndChangeDurationByDepartureCityContains(String departure, int nbMinutes);

    Mono<Void> deleteAllByDepartureCityContains(String departureCity);
}
