package home.oleg.dagger.di.components;

import android.content.Context;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import home.oleg.dagger.DaggerApplication;
import home.oleg.dagger.di.modules.ApplicationModule;
import home.oleg.dagger.di.modules.StorageModule;

/**
 * Created by Oleg on 22.04.2017.
 */
@Singleton
@Component(modules = {ApplicationModule.class, StorageModule.class})
public interface ApplicationComponent {
    void inject(DaggerApplication application);

    @Component.Builder
    interface AppComponentBuilder {
        ApplicationComponent build();

        @BindsInstance
        AppComponentBuilder bindContext(Context context);
    }
}

