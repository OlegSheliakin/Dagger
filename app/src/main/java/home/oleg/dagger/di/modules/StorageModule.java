package home.oleg.dagger.di.modules;

import android.support.annotation.NonNull;

import java.util.List;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;
import home.oleg.dagger.datastore.CachedStore;
import home.oleg.dagger.datastore.CloudStore;
import home.oleg.dagger.datastore.Store;
import home.oleg.dagger.datastore.StoreKey;
import home.oleg.dagger.datastore.StoreType;
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
public interface StorageModule {

    @NonNull
    @Binds
    @Singleton
    Repository<Item> provideRepository(ItemRepository itemRepository);

    @NonNull
    @Binds
    @Singleton
    Mapper<Item, ItemViewModel> provideMapper(ItemMapper mapper);

    @NonNull
    @Binds
    @IntoMap
    @StoreKey(StoreType.CACHED)
    Store<List<Item>> provideCachedStore(CachedStore cachedStore);

    @NonNull
    @Binds
    @IntoMap
    @StoreKey(StoreType.CLOUD)
    Store<List<Item>> provideCloudStore(CloudStore cloudStore);

}
