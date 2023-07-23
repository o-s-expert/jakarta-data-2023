package os.expert.examples;


import com.github.javafaker.Faker;
import jakarta.data.repository.Pageable;
import jakarta.data.repository.Sort;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.jnosql.mapping.Database;
import org.eclipse.jnosql.mapping.DatabaseType;

import java.util.List;

@ApplicationScoped
@Path("beers")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BeerResource {

    @Inject
    @Database(DatabaseType.DOCUMENT)
    private BeerRepository repository;


    @GET
    public List<Beer> findByAll(@QueryParam("page") @DefaultValue("1") long page,
                                @QueryParam("hop") @DefaultValue("") String hop,
                                @QueryParam("malt") @DefaultValue("") String malt){

        if(!hop.isBlank() && !malt.isBlank()){
            return this.repository.findByMaltAndHopOrderByName(malt, hop, Pageable.ofPage(page)).content();
        }
        else if(!hop.isBlank()) {
            return this.repository.findByHopOrderByName(hop, Pageable.ofPage(page)).content();
        }
        else if(!malt.isBlank()) {
            return this.repository.findByMaltOrderByName(malt, Pageable.ofPage(page)).content();
        }
        return this.repository.findAll(Pageable.ofPage(page)
                        .sortBy(Sort.asc("name")))
                .content();
    }

    @POST
    public void create(Beer beer){
        this.repository.save(beer);
    }

    @DELETE
    @Path("{id}")
    public void deleteById(@PathParam("id") String id){
        this.repository.deleteById(id);
    }

    @Path("random")
    @POST
    public void random() {
        var faker = new Faker();
        for (int index = 0; index < 1_000; index++) {
            var beer = Beer.of(faker);
            this.repository.save(beer);
        }
    }

}
