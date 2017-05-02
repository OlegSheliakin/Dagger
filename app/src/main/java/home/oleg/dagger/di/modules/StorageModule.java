package home.oleg.dagger.di.modules;

import android.support.annotation.NonNull;

import java.util.List;
import java.util.Map;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
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
public class StorageModule {

    @NonNull
    @Provides
    @Singleton
    public Repository<Item> provideRepository(Map<StoreType, Store<List<Item>>> stores) {
        return new ItemRepository(stores);
    }

    @NonNull
    @Provides
    @Singleton
    public Mapper<Item, ItemViewModel> provideMapper() {
        return new ItemMapper();
    }

    @NonNull
    @Provides
    @IntoMap
    @StoreKey(StoreType.CACHED)
    public Store<List<Item>> provideCachedStore(){
        return new CachedStore();
    }

    @NonNull
    @Provides
    @IntoMap
    @StoreKey(StoreType.CLOUD)
    public Store<List<Item>> provideCloudStore(){
        return new CloudStore();
    }

}
