package home.oleg.dagger.di;

import java.util.List;
import java.util.Set;

import javax.inject.Singleton;

import dagger.Component;
import home.oleg.dagger.MainActivity;
import home.oleg.dagger.entity.Item;
import home.oleg.dagger.mapping.Mapper;
import home.oleg.dagger.repo.Repository;
import home.oleg.dagger.view_model.ItemViewModel;

/**
 * Created by Oleg on 22.04.2017.
 */
@Singleton
@Component(modules = {ApplictaionModule.class, StorageModule.class, ActionModule.class})
public interface ApplicationComponent {
    Set<Action<List<Item>>> getSetActions();
    Repository<Item> getRepository();
    Mapper<Item, ItemViewModel> getMapper();
    DetailActivityComponent detailActivityComponent();
}
