package os.expert.examples;


import com.github.javafaker.Faker;
import jakarta.data.repository.Pageable;
import jakarta.data.repository.Sort;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@ApplicationScoped
@Path("beers")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
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
    public List<Beer> findByAll(@BeanParam BeerParam param){

        if(param.isMaltAndHopQuery()){
            return this.repository.findByMaltAndHopOrderByName(param.malt(), param.hop(), param.page()).content();
        }
        else if(param.isHopQuery()) {
            return this.repository.findByHopOrderByName(param.hop(), param.page()).content();
        }
        else if(param.isMaltQuery()) {
            return this.repository.findByMaltOrderByName(param.malt(), param.page()).content();
        }
        return this.repository.findAll(param.page().sortBy(Sort.asc("name"))).content();
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
