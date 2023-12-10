package pluralsight.flights.dal.listeners;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;
import pluralsight.flights.domain.FlightPlan;

@Component
public class FlightPlanCascadeMongoListener extends AbstractMongoEventListener<FlightPlan> {
    private final MongoTemplate mongoTemplate;

    public FlightPlanCascadeMongoListener(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public void onBeforeConvert(BeforeConvertEvent<FlightPlan> event) {
        var flightPlan = event.getSource();
        if (flightPlan.getAircraft() != null && flightPlan.getAircraft().getId() == null) {
            this.mongoTemplate.save(flightPlan.getAircraft());
        }
    }
}
