package pluralsight.flights.dal.converters;

import org.bson.Document;
import org.springframework.core.convert.converter.Converter;
import pluralsight.flights.domain.Aircraft;

public class AircraftWriteConverter implements Converter<Aircraft, Document> {
    @Override
    public Document convert(Aircraft source) {
        var document = new Document();
        document.put("model", source.getModel());
        document.put("capacity", source.getSeatCapacity());
        document.put("wakeTurbulence", source.getWakeTurbulence());

        var modelNameInWords = source.getModel().split(" ");
        // If model has many words, tge first one is the manufacturer
        if(modelNameInWords.length > 1){
            document.put("manufacturer", modelNameInWords[0]);
        } else{
            document.put("manufacturer", "N/A");
        }

        return document;
    }
}
