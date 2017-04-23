package home.oleg.dagger.di;

import dagger.Subcomponent;
import home.oleg.dagger.MainActivity;

/**
 * Created by Oleg on 23.04.2017.
 */

@Subcomponent(modules = MainActivityModule.class)
@PerActivity
public interface DetailActivityComponent {
    void inject(MainActivity activity);
}
