package home.oleg.dagger.di.modules;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import home.oleg.dagger.DetailActivity;
import home.oleg.dagger.MainActivity;
import home.oleg.dagger.di.ActivityComponent;
import home.oleg.dagger.di.ActivityComponentBuilder;
import home.oleg.dagger.di.BindableActivity;
import home.oleg.dagger.di.components.DetailComponent;
import home.oleg.dagger.di.components.MainActivityComponent;

/**
 * Created by Oleg on 22.04.2017.
 */

@Module(subcomponents = {MainActivityComponent.class, DetailComponent.class})
public interface ApplicationModule {

    @Binds
    @IntoMap
    @ClassKey(MainActivity.class)
    ActivityComponentBuilder provideMainActivityBuilder(MainActivityComponent.Builder builder);

    @Binds
    @IntoMap
    @ClassKey(DetailActivity.class)
    ActivityComponentBuilder provideDetailActivityBuilder(DetailComponent.Builder builder);

}
