package pluralsight.flights.dal;

import org.springframework.data.mongodb.repository.MongoRepository;
import pluralsight.flights.domain.Aircraft;

public interface AircraftRepository extends MongoRepository<Aircraft, String> {
}
