package home.oleg.dagger.di.components;

import dagger.Subcomponent;
import home.oleg.dagger.MainActivity;
import home.oleg.dagger.di.ActivityComponent;
import home.oleg.dagger.di.ActivityComponentBuilder;
import home.oleg.dagger.di.modules.MainActivityModule;
import home.oleg.dagger.di.scopes.PerActivity;

/**
 * Created by Oleg on 22.04.2017.
 */
@PerActivity
@Subcomponent(modules = MainActivityModule.class)
public interface MainActivityComponent extends ActivityComponent<MainActivity> {
    void inject (MainActivity activity);

    @Subcomponent.Builder
    interface Builder extends ActivityComponentBuilder<MainActivityComponent, MainActivityModule> {
    }
}
