package pluralsight.flights;

import org.springframework.beans.support.SortDefinition;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.index.TextIndexDefinition;
import org.springframework.data.mongodb.core.query.*;
import org.springframework.stereotype.Component;
import pluralsight.flights.dal.FlightPlanRepository;
import pluralsight.flights.domain.Address;
import pluralsight.flights.domain.Airport;
import pluralsight.flights.domain.CrewMember;

import java.util.List;

/*
This component will be executed by Spring Framework immediately after application
bootstrap
 */
@Component
public class MainRunner implements CommandLineRunner {
    private MongoOperations mongoOperations;

    public MainRunner(MongoOperations mongoTemplate) {
        this.mongoOperations = mongoTemplate;
    }

    @Override
    public void run(String... args) throws Exception {


        var textIndexDef = TextIndexDefinition
                .builder()
                .onField("title")
                .onField("aboutMe")
                .build();
        mongoOperations.indexOps(CrewMember.class).ensureIndex(textIndexDef);

        var fabian = new CrewMember("Fabian", "Senior Pilot", "I am preparing to be a captain");
        var john = new CrewMember("John", "Captain", "I am a pilot");
        var anna = new CrewMember("Anna", "Co-Pilot", "I am learning to fly");

        mongoOperations.insert(List.of(fabian, john, anna), CrewMember.class);

        // Define text criteria
        TextCriteria textCriteria = TextCriteria
                .forDefaultLanguage()
                .matching("Captain")
                .caseSensitive(false);

        // Define query
        Query query = TextQuery.queryText(textCriteria)
                .sortByScore();

        // Execute query
        var result = mongoOperations.find(query, CrewMember.class);

        System.out.println(result);
    }
}
