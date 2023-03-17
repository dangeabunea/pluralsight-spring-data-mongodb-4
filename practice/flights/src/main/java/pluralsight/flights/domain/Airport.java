package pluralsight.flights.domain;

import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public record Airport(String id,
                      @TextIndexed
                      String name,
                      int nbRunways,
                      boolean international,
                      Address address) {
}
