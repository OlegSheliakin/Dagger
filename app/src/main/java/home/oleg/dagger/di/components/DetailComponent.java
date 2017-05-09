package home.oleg.dagger.di.components;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import home.oleg.dagger.DetailActivity;
import home.oleg.dagger.di.ActivityComponentBuilder;
import home.oleg.dagger.di.modules.DetailModule;
import home.oleg.dagger.di.scopes.PerActivity;

/**
 * Created by Oleg on 01.05.2017.
 */
@PerActivity
@Subcomponent(modules = DetailModule.class)
public interface DetailComponent extends AndroidInjector<DetailActivity> {

    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<DetailActivity> {
    }
}
