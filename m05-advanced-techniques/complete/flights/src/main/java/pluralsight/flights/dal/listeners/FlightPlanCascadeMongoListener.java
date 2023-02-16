package pluralsight.flights.dal.listeners;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;
import pluralsight.flights.domain.FlightPlan;

@Component
public class FlightPlanCascadeMongoListener extends AbstractMongoEventListener<Object> {
    private MongoTemplate mongoTemplate;

    public FlightPlanCascadeMongoListener(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public void onBeforeConvert(BeforeConvertEvent<Object> event) {
        Object source = event.getSource();
        if ((source instanceof FlightPlan) && (((FlightPlan) source).getAircraft() != null)) {
            mongoTemplate.save(((FlightPlan) source).getAircraft());
        }
    }
}
