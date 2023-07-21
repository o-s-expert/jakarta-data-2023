package os.expert.examples;


import com.github.javafaker.Faker;
import jakarta.json.bind.annotation.JsonbVisibility;

import java.util.Objects;
import java.util.UUID;

@JsonbVisibility(FieldVisibilityStrategy.class)
public class EclipseStoreBeer implements Beer {

   private String id;
   private String name;

    private String style;

    private String hop;

    private  String yeast;

    private String malt;

    private EclipseStoreAddress address;

    private  String user;

    public String id() {
        return id;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public String style() {
        return style;
    }

    @Override
    public String hop() {
        return hop;
    }

    @Override
    public String yeast() {
        return yeast;
    }

    @Override
    public String malt() {
        return malt;
    }

    @Override
    public EclipseStoreAddress address() {
        return address;
    }

    @Override
    public String user() {
        return user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EclipseStoreBeer that = (EclipseStoreBeer) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Beer{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", style='" + style + '\'' +
                ", hop='" + hop + '\'' +
                ", yeast='" + yeast + '\'' +
                ", malt='" + malt + '\'' +
                ", address=" + address +
                ", user='" + user + '\'' +
                '}';
    }

    public static EclipseStoreBeer of(Faker faker){
        var beer = faker.beer();
        EclipseStoreBeer entity = new EclipseStoreBeer();
        entity.id = UUID.randomUUID().toString();
        entity.name = beer.name();
        entity.style = beer.style();
        entity.hop = beer.hop();
        entity.yeast = beer.yeast();
        entity.malt = beer.malt();
        entity.user = faker.dragonBall().character();
        entity.address = EclipseStoreAddress.of(faker);
        return entity;
    }
}
