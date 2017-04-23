package home.oleg.dagger.di;

import android.support.annotation.NonNull;

import dagger.Module;
import dagger.Provides;
import home.oleg.dagger.entity.Item;
import home.oleg.dagger.mapping.ItemMapper;
import home.oleg.dagger.mapping.Mapper;
import home.oleg.dagger.repo.ItemRepository;
import home.oleg.dagger.repo.Repository;
import home.oleg.dagger.view_model.ItemViewModel;

/**
 * Created by Oleg on 22.04.2017.
 */

@Module
public class StorageModule {

    @NonNull
    @Provides
    public Repository<Item> provideRepository() {
        return new ItemRepository();
    }

    @NonNull
    @Provides
    public Mapper<Item, ItemViewModel> provideMapper() {
        return new ItemMapper();
    }

}
