package pluralsight.flights.domain;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Address {
    public String id;
    public String value;
}
