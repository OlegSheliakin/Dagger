package home.oleg.dagger.di.components;

import dagger.Component;
import home.oleg.dagger.DetailActivity;
import home.oleg.dagger.di.modules.ApplictaionModule;
import home.oleg.dagger.di.modules.DetailModule;

/**
 * Created by Oleg on 01.05.2017.
 */
@Component(modules = {DetailModule.class, ApplictaionModule.class, /*NetworkModule.class*/})
public interface DetailComponent {
    void inject(DetailActivity activity);
}
