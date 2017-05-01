package home.oleg.dagger.mapping;

import home.oleg.dagger.entity.Item;
import home.oleg.dagger.view_model.ItemViewModel;

/**
 * Created by Oleg on 22.04.2017.
 */

public class ItemMapper implements Mapper<Item, ItemViewModel> {

    @Override
    public ItemViewModel map(Item item) {
        return new ItemViewModel(item.getName(), item.getDescription());
    }
}
