package home.oleg.dagger.di;

import dagger.BindsInstance;

/**
 * Created by Oleg on 08.05.2017.
 */

public interface ActivityComponentBuilder<COMPONENT extends ActivityComponent<? extends BindableActivity>> {
    COMPONENT build();

    @BindsInstance
    ActivityComponentBuilder<COMPONENT> activity(BindableActivity activity);


}
