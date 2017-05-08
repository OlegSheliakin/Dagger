package home.oleg.dagger.di.modules;

import android.content.Context;
import android.support.annotation.NonNull;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import dagger.producers.Production;
import home.oleg.dagger.DetailActivity;
import home.oleg.dagger.MainActivity;
import home.oleg.dagger.di.ActivityComponent;
import home.oleg.dagger.di.ActivityComponentBuilder;
import home.oleg.dagger.di.ActivityModule;
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
