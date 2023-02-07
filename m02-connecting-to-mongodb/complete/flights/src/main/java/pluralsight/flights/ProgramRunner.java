package pluralsight.flights;

import org.springframework.boot.CommandLineRunner;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;
import pluralsight.flights.domain.Airport;

/*
The "run" method will be called by Spring Framework
 */
@Component
public class ProgramRunner implements CommandLineRunner {
    private MongoTemplate mongoTemplate;

    public ProgramRunner(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public void run(String... args) throws Exception {
        var airports = mongoTemplate.find(new Query(), Airport.class);
        airports.forEach(System.out::println);
    }
}
