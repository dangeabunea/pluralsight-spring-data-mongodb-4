package pluralsight.flights.dal.converters;

import org.bson.Document;
import org.springframework.core.convert.converter.Converter;
import pluralsight.flights.domain.Aircraft;
import pluralsight.flights.domain.FlightPlan;
import pluralsight.flights.domain.WakeTurbulence;

import java.time.LocalDateTime;
import java.time.ZoneId;

public class FlightPlanReadConverter implements Converter<Document, FlightPlan> {
    @Override
    public FlightPlan convert(Document source) {
        var departure = source.getString("departure");
        var destination = source.getString("destination");
        var departureDate = source.getDate("departureDateTime");
        var flightDuration = source.getInteger("flightDuration");
        var crossedCountries = source.getList("crossedCountries", String.class);
        var international = source.getBoolean("isInternational");

        Document plane = (Document) source.get("aircraft");
        var planeModel = plane.getString("model");
        var planeCapacity = plane.getInteger("capacity");
        var planeTurbulence = plane.getString("wakeTurbulence");


        var dest = new FlightPlan(
                departure,
                destination,
                LocalDateTime.ofInstant(departureDate.toInstant(),  ZoneId.systemDefault()),
                flightDuration * 60,
                crossedCountries,
                international,
                new Aircraft(planeModel, planeCapacity, WakeTurbulence.valueOf(planeTurbulence))
        );

        return dest;
    }
}
