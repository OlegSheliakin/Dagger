package home.oleg.dagger;

import java.util.List;

import home.oleg.dagger.view_model.ItemViewModel;

/**
 * Created by Oleg on 22.04.2017.
 */

public interface MainView {
    void showItems(List<ItemViewModel> itemViewModels);
}
