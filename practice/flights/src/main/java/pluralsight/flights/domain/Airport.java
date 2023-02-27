package pluralsight.flights.domain;

import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.annotation.PersistenceCreator;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Airport {
    private String id;
    private String name;
    private String code;
    private int nbRunways;
    private boolean international;
    private Address address;

    @PersistenceCreator
    public Airport(String name, String code,
            int nbRunways, boolean international){
        this.name = name;
        this.code = code;
        this.nbRunways = nbRunways;
        this.international = international;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getNbRunways() {
        return nbRunways;
    }

    public void setNbRunways(int nbRunways) {
        this.nbRunways = nbRunways;
    }

    public boolean isInternational() {
        return international;
    }

    public void setInternational(boolean international) {
        this.international = international;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
