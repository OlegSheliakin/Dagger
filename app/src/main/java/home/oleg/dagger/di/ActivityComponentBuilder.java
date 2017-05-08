package home.oleg.dagger.di;

/**
 * Created by Oleg on 08.05.2017.
 */

public interface ActivityComponentBuilder<COMPONENT extends ActivityComponent, MODULE extends ActivityModule> {
    COMPONENT build();

    ActivityComponentBuilder<COMPONENT, MODULE> module(MODULE module);
}
