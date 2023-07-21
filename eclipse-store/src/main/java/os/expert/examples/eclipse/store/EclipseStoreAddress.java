package os.expert.examples.eclipse.store;

public class EclipseStoreAddress implements os.expert.examples.Address {

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
