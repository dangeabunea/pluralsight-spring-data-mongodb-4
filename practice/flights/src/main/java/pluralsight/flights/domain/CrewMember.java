package pluralsight.flights.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class CrewMember {
    @Id
    public String id;

    String name;

    @TextIndexed
    String title;

    @TextIndexed
    String aboutMe;

    public CrewMember(String name, String title, String aboutMe){
        this.name = name;
        this.title = title;
        this.aboutMe = aboutMe;
    }

    @Override
    public String toString() {
        return "CrewMember{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", title='" + title + '\'' +
                ", aboutMe='" + aboutMe + '\'' +
                '}';
    }
}
