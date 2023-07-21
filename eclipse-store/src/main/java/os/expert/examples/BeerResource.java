package os.expert.examples;


import com.github.javafaker.Faker;
import jakarta.data.repository.Pageable;
import jakarta.data.repository.Sort;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;

import java.util.List;

@ApplicationScoped
@Path("beers")
public class BeerResource {

    private final BeerRepository repository;

    @Inject
    public BeerResource(BeerRepository repository) {
        this.repository = repository;
    }

    @Deprecated
    BeerResource() {
        this(null);
    }


    @GET
    public List<EclipseStoreBeer> findByAll(@QueryParam("page") @DefaultValue("1") long page){
        return this.repository.findAll(Pageable.ofPage(page).sortBy(Sort.asc("name"))).content();
    }

    @Path("random")
    public void random() {
        var faker = new Faker();
        for (int index = 0; index < 1_000; index++) {
            var beer = EclipseStoreBeer.of(faker);
            this.repository.save(beer);
        }
    }

}
