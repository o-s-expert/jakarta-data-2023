package os.expert.examples.eclipse.store;

import os.expert.examples.Address;

public class EclipseStoreBeer implements os.expert.examples.Beer {


    private String name;

    private String style;

    private String hop;

    private String yeast;

    private String malt;

    private Address address;

    private String user;

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
    public Address address() {
        return address;
    }

    @Override
    public String user() {
        return user;
    }
}
