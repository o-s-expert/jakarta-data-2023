package os.expert.examples;


import com.github.javafaker.Faker;
import jakarta.json.bind.annotation.JsonbVisibility;

import java.util.Objects;

@JsonbVisibility(FieldVisibilityStrategy.class)
public class EclipseStoreAddress implements Address {

    private String city;

    private String country;
    @Override
    public String city() {
        return city;
    }

    @Override
    public String country() {
        return country;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EclipseStoreAddress address = (EclipseStoreAddress) o;
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

    public static EclipseStoreAddress of(Faker faker){
        EclipseStoreAddress entity = new EclipseStoreAddress();
        var address = faker.address();
        entity.city = address.city();
        entity.country = address.country();
        return entity;
    }

}
