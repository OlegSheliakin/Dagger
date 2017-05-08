package home.oleg.dagger.di.components;

import dagger.Component;
import dagger.Subcomponent;
import home.oleg.dagger.DetailActivity;
import home.oleg.dagger.di.ActivityComponent;
import home.oleg.dagger.di.ActivityComponentBuilder;
import home.oleg.dagger.di.modules.ApplicationModule;
import home.oleg.dagger.di.modules.DetailModule;
import home.oleg.dagger.di.scopes.PerActivity;

/**
 * Created by Oleg on 01.05.2017.
 */
@PerActivity
@Subcomponent(modules = DetailModule.class)
public interface DetailComponent extends ActivityComponent<DetailActivity>{

    @Subcomponent.Builder
    interface Builder extends ActivityComponentBuilder<DetailComponent>{
    }
}
