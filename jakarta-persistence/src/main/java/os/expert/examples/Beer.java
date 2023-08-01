package os.expert.examples;


import com.github.javafaker.Faker;
import jakarta.json.bind.annotation.JsonbVisibility;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@JsonbVisibility(FieldVisibilityStrategy.class)
public class Beer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
   private String name;

    @Column
    private String style;
    @Column
    private String hop;
    @Column
    private  String yeast;
    @Column
    private String malt;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;
    @Column(name = "BEERUSER") //USER is reserved in Postgres
    private  String user;

    public long id() {
        return id;
    }

    public String name() {
        return name;
    }

    public String style() {
        return style;
    }

    public String hop() {
        return hop;
    }

    public String yeast() {
        return yeast;
    }

    public String malt() {
        return malt;
    }

    public Address address() {
        return address;
    }

    public String user() {
        return user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Beer that = (Beer) o;
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

    public static Beer of(Faker faker){
        var beer = faker.beer();
        Beer entity = new Beer();
        entity.name = stripUnicode(beer.name());
        entity.style = stripUnicode(beer.style());
        entity.hop = stripUnicode(beer.hop());
        entity.yeast = stripUnicode(beer.yeast());
        entity.malt = stripUnicode(beer.malt());
        entity.user = stripUnicode(faker.dragonBall().character());
        entity.address = Address.of(faker);
        return entity;
    }

    //OpenLiberty's JPA implemenation doesn't allow Unicode on Postgres
    //This is temporary until that can be fixed and released.
    public static String stripUnicode(String s) {
        StringBuilder sb = new StringBuilder();
        for (int c : s.toCharArray()) {
            if (c < 128) {
                sb.append((char)c);
            }
        }
        return sb.toString();
    }
}
