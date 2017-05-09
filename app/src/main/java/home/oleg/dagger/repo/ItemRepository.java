package home.oleg.dagger.repo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import home.oleg.dagger.datastore.Store;
import home.oleg.dagger.datastore.StoreType;
import home.oleg.dagger.entity.Item;

/**
 * Created by Oleg on 22.04.2017.
 */

public class ItemRepository implements Repository<Item> {

    private final Map<StoreType, Store<List<Item>>> stores;

    @Inject
    public ItemRepository(Map<StoreType, Store<List<Item>>> stores) {
        this.stores = stores;
    }

    @Override
    public List<Item> getAll() {
        List<Item> items = new ArrayList<>();
        items.addAll(stores.get(StoreType.CACHED).get());
        items.addAll(stores.get(StoreType.CLOUD).get());
        return items;
    }

    @Override
    public Item get(String name) {
        return null;
    }

    @Override
    public void remove(Item item) {

    }
}
