package os.expert.examples;


import jakarta.json.bind.annotation.JsonbVisibility;
import jakarta.nosql.Column;
import jakarta.nosql.Entity;
import net.datafaker.Faker;

import java.util.Objects;

@Entity
@JsonbVisibility(FieldVisibilityStrategy.class)
public class Address {

    @Column
    private String city;

    @Column
    private String country;
    public String city() {
        return city;
    }

    public String country() {
        return country;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(city, address.city) && Objects.equals(country, address.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, country);
    }

    @Override
    public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                ", country='" + country + '\'' +
                '}';
    }

    public static Address of(Faker faker){
        Address entity = new Address();
        var address = faker.address();
        entity.city = address.city();
        entity.country = address.country();
        return entity;
    }

}
