package pluralsight.flights.dal.converters;

import org.bson.Document;
import org.springframework.core.convert.converter.Converter;
import pluralsight.flights.domain.FlightPlan;

public class FlightPlanWriteConverter implements Converter<FlightPlan, Document> {
    @Override
    public Document convert(FlightPlan source) {
        var document = new Document();
        document.put("_id", source.getId());
        document.put("departure", source.getDepartureCity());
        document.put("destination", source.getDestinationCity());
        document.put("departureDateTime", source.getDepartureDateTime());
        document.put("crossedCountries", source.getCrossedCountries());
        document.put("isInternational", source.isInternational());
        document.put("flightDuration", source.getFlightDuration() / 60);

        var planeDocument = new Document();
        planeDocument.put("model", source.getAircraft().getModel());
        planeDocument.put("capacity", source.getAircraft().getSeatCapacity());
        planeDocument.put("wakeTurbulence", source.getAircraft().getWakeTurbulence());
        document.put("aircraft", planeDocument);

        return document;
    }
}
