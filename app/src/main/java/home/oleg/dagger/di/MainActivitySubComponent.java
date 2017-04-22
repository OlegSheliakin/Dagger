package home.oleg.dagger.di;

import dagger.Subcomponent;
import home.oleg.dagger.MainActivity;

/**
 * Created by Oleg on 22.04.2017.
 */
@PerActivity
@Subcomponent
public interface MainActivitySubComponent {
    void inject(MainActivity activity);
}
