package os.expert.examples;


import jakarta.json.bind.annotation.JsonbVisibility;

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
}
