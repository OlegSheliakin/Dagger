package home.oleg.dagger.di.components;

import dagger.Subcomponent;
import home.oleg.dagger.MainActivity;
import home.oleg.dagger.di.modules.MainActivityModule;
import home.oleg.dagger.di.scopes.PerActivity;

/**
 * Created by Oleg on 22.04.2017.
 */
@PerActivity
@Subcomponent(modules = MainActivityModule.class)
public interface MainActivityComponent {
    void inject (MainActivity activity);
}
