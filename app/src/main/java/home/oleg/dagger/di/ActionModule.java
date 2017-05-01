package home.oleg.dagger.di;

import android.support.annotation.NonNull;
import android.util.Log;

import java.util.Collections;
import java.util.List;

import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoSet;
import home.oleg.dagger.Aaa;
import home.oleg.dagger.entity.Item;
import home.oleg.dagger.repo.Repository;

/**
 * Created by Oleg on 23.04.2017.
 */
@Module
public class ActionModule {

    @NonNull
    @Provides
    @IntoSet
    public Action<List<Item>> provideSortAction(Aaa aaa) {
        return items -> Collections.sort(items, (i1, i2) -> i1.getName().compareTo(i2.getName()));
    }

    @NonNull
    @Provides
    @IntoSet
    public Action<List<Item>> provideLogAction() {
        return items -> Log.d("Items", items.toString());
    }

    @NonNull
    @Provides
    @IntoSet
    public Action<List<Item>> provideFillAction(Repository<Item> repository) {
        return items -> {
            for (Item item : items) {
                if (item.isExpired()) {
                    repository.remove(item);
                }
            }
        };
    }

    @Provides
    public Aaa provideAaa() {
        return new Aaa();
    }
}
