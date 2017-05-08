package home.oleg.dagger.datastore;

/**
 * Created by Oleg on 01.05.2017.
 */

public class HeavyExternalLibrary {

    private boolean initialized = false;

    public HeavyExternalLibrary() {}

    public void init() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        initialized = true;
    }

    public void callMethod() {
        if (!initialized) throw new RuntimeException("Call init() before you use this library");
        System.out.println("method from heavy library");
    }

}
