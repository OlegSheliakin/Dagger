package home.oleg.dagger.di.modules;

import android.support.annotation.NonNull;
import android.util.Log;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoSet;
import home.oleg.dagger.datastore.Action;
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
    public static Action<List<Item>> provideSortAction() {
        return new Action<List<Item>>() {
            @Override
            public void perform(List<Item> items) {
                Collections.sort(items, new Comparator<Item>() {
                    @Override
                    public int compare(Item i1, Item i2) {
                        return i1.getName().compareTo(i2.getName());
                    }
                });
            }
        };
    }

    @NonNull
    @Provides
    @IntoSet
    public static Action<List<Item>> provideLogAction() {
        return new Action<List<Item>>() {
            @Override
            public void perform(List<Item> items) {
                Log.d("Items", items.toString());
            }
        };
    }

    @NonNull
    @Provides
    @IntoSet
    public static Action<List<Item>> provideFillAction(final Repository<Item> repository) {
        return new Action<List<Item>>() {
            @Override
            public void perform(List<Item> items) {
                for (Item item : items) {
                    if (item.isExpired()) {
                        repository.remove(item);
                    }
                }
            }
        };
    }

}
