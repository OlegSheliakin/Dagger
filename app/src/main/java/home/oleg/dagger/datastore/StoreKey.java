package home.oleg.dagger.datastore;

import dagger.MapKey;

/**
 * Created by Oleg on 23.04.2017.
 */
@MapKey
public @interface StoreKey {
    StoreType value();
}
