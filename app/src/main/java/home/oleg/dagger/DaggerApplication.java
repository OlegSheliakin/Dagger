package home.oleg.dagger;

import android.app.Application;

import home.oleg.dagger.di.ApplicationComponent;
import home.oleg.dagger.di.ApplictaionModule;
import home.oleg.dagger.di.DaggerApplicationComponent;

/**
 * Created by Oleg on 22.04.2017.
 */

public class DaggerApplication extends Application {

    private static ApplicationComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        component = DaggerApplicationComponent.builder()
                .applictaionModule(new ApplictaionModule(this)).build();
    }

    public static ApplicationComponent getComponent() {
        return component;
    }

}
