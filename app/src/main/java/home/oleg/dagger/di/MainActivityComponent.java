package home.oleg.dagger.di;

import com.google.common.util.concurrent.ListenableFuture;

import dagger.Component;
import dagger.Subcomponent;
import dagger.producers.ProductionSubcomponent;
import home.oleg.dagger.MainActivity;
import home.oleg.dagger.entity.Item;

/**
 * Created by Oleg on 22.04.2017.
 */
@PerActivity
@Subcomponent(modules = MainActivityModule.class)
public interface MainActivityComponent {
    void inject (MainActivity activity);
}
