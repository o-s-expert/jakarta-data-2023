package os.expert.examples;

import jakarta.data.repository.Pageable;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.QueryParam;

public class BeerParam {

    @QueryParam("page") @DefaultValue("1")
    private long page;
    @QueryParam("hop") @DefaultValue("")
    private String hop;
    @QueryParam("malt") @DefaultValue("")
    private String malt;

    public Pageable page() {
        return Pageable.ofPage(page);
    }
    public String hop() {
        return hop;
    }

    public String malt() {
        return malt;
    }

    public boolean isMaltAndHopQuery(){
        return !hop.isBlank() && !malt.isBlank();
    }

    public boolean isMaltQuery() {
        return !malt.isBlank();
    }

    public boolean isHopQuery(){
       return !hop.isBlank();
    }
}
