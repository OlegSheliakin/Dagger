package home.oleg.dagger.di;

import javax.inject.Singleton;

import dagger.Component;
import home.oleg.dagger.MainActivity;

/**
 * Created by Oleg on 22.04.2017.
 */
@Singleton
@Component(modules = {ApplictaionModule.class, StorageModule.class, MainActivityModule.class})
public interface ApplicationComponent {
    void inject(MainActivity mainActivity);
}
