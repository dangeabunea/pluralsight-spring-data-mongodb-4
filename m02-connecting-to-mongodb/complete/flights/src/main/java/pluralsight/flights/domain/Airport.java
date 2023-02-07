package pluralsight.flights.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "airports")
public class Airport {
    @Id
    private String id;
    private String name;
    private int runwayLength;

    @Field("latitude")
    private double lat;

    @Field("longitude")
    private double lon;

    public Airport(String name, int runwayLength, double lat, double lon) {
        this.name = name;
        this.runwayLength = runwayLength;
        this.lat = lat;
        this.lon = lon;
    }

    public String getName() {
        return name;
    }

    public int getRunwayLength() {
        return runwayLength;
    }

    public void setRunwayLength(int runwayLength) {
        this.runwayLength = runwayLength;
    }

    public double getLat() {
        return lat;
    }

    public double getLon() {
        return lon;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return String.format("{id: %s, name: %s, runwayLength: %s, lat: %.1f, lon: %.1f}",
                this.id,
                this.name,
                this.runwayLength,
                this.lat,
                this.lon);
    }
}
