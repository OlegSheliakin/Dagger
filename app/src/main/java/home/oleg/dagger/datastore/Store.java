package home.oleg.dagger.datastore;

/**
 * Created by Oleg on 23.04.2017.
 */

public interface Store<DATA> {
    DATA get();
}
