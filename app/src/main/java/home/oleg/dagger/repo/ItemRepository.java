package home.oleg.dagger.repo;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import home.oleg.dagger.entity.Item;

/**
 * Created by Oleg on 22.04.2017.
 */

public class ItemRepository implements Repository<Item> {

    @Inject
    public ItemRepository(){}

    @Override
    public List<Item> getAll() {
        return Arrays.asList(new Item("1", "first item"), new Item("2", "second item"));
    }
}
