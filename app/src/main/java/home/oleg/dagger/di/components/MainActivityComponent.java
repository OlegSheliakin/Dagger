package home.oleg.dagger.di.components;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import home.oleg.dagger.DetailActivity;
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
public interface MainActivityComponent extends AndroidInjector<MainActivity> {

    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<MainActivity> {
    }
}
