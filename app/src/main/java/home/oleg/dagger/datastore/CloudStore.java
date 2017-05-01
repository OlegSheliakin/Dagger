package home.oleg.dagger.datastore;

import java.util.Arrays;
import java.util.List;

import home.oleg.dagger.entity.Item;

/**
 * Created by Oleg on 23.04.2017.
 */

public class CloudStore implements Store<List<Item>> {

    @Override
    public List<Item> get() {
        return Arrays.asList(new Item("1", "first item"), new Item("2", "second item"));
    }
}
