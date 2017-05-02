package home.oleg.dagger.di.components;

import javax.inject.Singleton;

import dagger.Component;
import home.oleg.dagger.di.modules.ApplictaionModule;
import home.oleg.dagger.di.modules.StorageModule;

/**
 * Created by Oleg on 22.04.2017.
 */
@Singleton
@Component(modules = {ApplictaionModule.class, StorageModule.class/*, ActionModule.class*/})
public interface ApplicationComponent {
    MainActivityComponent mainActivityComponent();
}
