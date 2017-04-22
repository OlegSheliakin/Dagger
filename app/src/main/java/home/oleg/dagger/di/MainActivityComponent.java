package home.oleg.dagger.di;

import home.oleg.dagger.MainActivity;

/**
 * Created by Oleg on 22.04.2017.
 */
@PerActivity
//@Component(dependencies = ApplicationComponent.class)
public interface MainActivityComponent {
    void inject (MainActivity activity);
}
