package pluralsight.flights.domain;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public record Aerodrome(String id, String name, String runwayLength) {
}
