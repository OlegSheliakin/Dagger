package home.oleg.dagger.di.modules;

import android.app.Activity;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
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
    @ActivityKey(MainActivity.class)
    AndroidInjector.Factory<? extends Activity> provideMainActivityBuilder(MainActivityComponent.Builder builder);

    @Binds
    @IntoMap
    @ActivityKey(DetailActivity.class)
    AndroidInjector.Factory<? extends Activity> provideDetailActivityBuilder(DetailComponent.Builder builder);

}
