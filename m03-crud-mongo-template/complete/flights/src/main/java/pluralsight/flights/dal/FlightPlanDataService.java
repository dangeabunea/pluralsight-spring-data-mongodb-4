package pluralsight.flights.dal;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import pluralsight.flights.domain.AircraftFactory;
import pluralsight.flights.domain.FlightPlan;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class FlightPlanDataService {
    private MongoTemplate mongoTemplate;

    public FlightPlanDataService(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public void insertInitialFlightPlans() {
        // Insert a single document
        var parisToLondon = new FlightPlan(
                "Paris",
                "London",
                LocalDateTime.of(2023, 6, 1, 20, 15),
                90,
                List.of("France", "England"),
                true,
                AircraftFactory.buildBoeing737()
        );
        this.mongoTemplate.insert(parisToLondon);

        // Insert a list of documents
        var parisToNice = new FlightPlan(
                "Paris. France",
                "Nice, France",
                LocalDateTime.of(2023, 7, 3, 9, 0),
                100,
                List.of("France"),
                false,
                AircraftFactory.buildEmbraerE175()
        );

        var istanbulToPhuket = new FlightPlan(
                "Istanbul, Turkey",
                "Phuket, Thailand",
                LocalDateTime.of(2023, 12, 15, 22, 50),
                600,
                List.of("Turkey", "Iran", "Pakistan", "India", "Thailand"),
                true,
                AircraftFactory.buildAirbusA350()
        );

        var berlinToNewYork = new FlightPlan(
                "Berlin, Germany",
                "New York, United States",
                LocalDateTime.of(2023, 9, 5, 15, 0),
                420,
                List.of("Germany", "England", "United States"),
                true,
                AircraftFactory.buildBoeing747()
        );

        var viennaToBucharest = new FlightPlan(
                "Vienna, Austria",
                "Bucharest, Romania",
                LocalDateTime.of(2023, 8, 1, 11, 30),
                75,
                List.of("Austria", "Hungary", "Romania"),
                true,
                AircraftFactory.buildBoeing737()
        );

        var flightPlans = List.of(
                parisToNice,
                viennaToBucharest,
                berlinToNewYork,
                istanbulToPhuket
        );

        mongoTemplate.insertAll(flightPlans);
    }

    public FlightPlan findById(String id) {
        return this.mongoTemplate.findById(id, FlightPlan.class);
    }

    public List<FlightPlan> findInternationalCrossingFrance() {
        var isInternational = Criteria.where("isInternational").is(true);
        var crossingFrance = Criteria.where("crossedCountries").in("France");
        var criteria = new Criteria().andOperator(List.of(isInternational, crossingFrance));
        var query = new Query(criteria);

        return this.mongoTemplate.find(query, FlightPlan.class);
    }

    public List<FlightPlan> findFirstTwoFlightsWhichLastBetweenOneAndThreeHours() {
        var criteria = Criteria.where("flightDuration").gte(60).lte(180);

        var query = new Query(criteria).with(PageRequest.of(0, 2));

        return this.mongoTemplate.find(query, FlightPlan.class);
    }

    public List<FlightPlan> findBoeingFlightsAndOrderBySeatCapacity() {
        var withBoeing = Criteria.where("aircraft.model").regex("Boeing");

        var query = new Query(withBoeing)
                .with(Sort.by("aircraft.capacity").descending());

        return this.mongoTemplate.find(query, FlightPlan.class);
    }
}
