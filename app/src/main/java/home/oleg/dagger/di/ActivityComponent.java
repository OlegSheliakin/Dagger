package home.oleg.dagger.di;

/**
 * Created by Oleg on 08.05.2017.
 */

public interface ActivityComponent<ACTIVITY extends BindableActivity> {
    void inject(ACTIVITY activity);
}
