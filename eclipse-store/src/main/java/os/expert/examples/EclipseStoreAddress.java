package os.expert.examples;

public class EclipseStoreAddress implements Address{

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
}
