package home.oleg.dagger.di;

import dagger.Component;
import dagger.Subcomponent;
import home.oleg.dagger.MainActivity;

/**
 * Created by Oleg on 22.04.2017.
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = MainActivityModule.class)
public interface MainActivityComponent {
    void inject (MainActivity activity);
}
