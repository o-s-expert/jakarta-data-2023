package os.expert.examples;


import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.nosql.document.DocumentTemplate;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import net.datafaker.Faker;

import java.util.List;

@ApplicationScoped
@Path("beers2")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BeerTemplateResource {

    private final DocumentTemplate template;

    @Inject
    public BeerTemplateResource(DocumentTemplate template) {
        this.template = template;
    }

    @Deprecated
    BeerTemplateResource() {
        this(null);
    }


    @GET
    public List<Beer> findByAll(@BeanParam BeerParam param){

        if(param.isMaltAndHopQuery()){
           return this.template.select(Beer.class).where("malt")
                    .eq(param.malt())
                    .and("hop")
                    .eq(param.hop())
                    .result();
        }
        else if(param.isHopQuery()) {
            return this.template.select(Beer.class).where("hop")
                    .eq(param.hop())
                    .result();
        }
        else if(param.isMaltQuery()) {
            return this.template.select(Beer.class).where("malt")
                    .eq(param.malt())
                    .result();
        }
        return this.template.select(Beer.class).result();
    }

    @POST
    public void create(Beer beer){
        this.template.insert(beer);
    }

    @DELETE
    @Path("{id}")
    public void deleteById(@PathParam("id") String id){
        this.template.delete(Beer.class).where("id").eq(id).execute();
    }

    @Path("random")
    @POST
    public void random() {
        var faker = new Faker();
        for (int index = 0; index < 1_000; index++) {
            var beer = Beer.of(faker);
            this.template.insert(beer);
        }
    }

}
