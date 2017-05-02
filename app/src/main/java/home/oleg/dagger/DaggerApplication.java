package home.oleg.dagger;

import android.app.Application;

import com.frogermcs.androiddevmetrics.AndroidDevMetrics;

import home.oleg.dagger.di.components.ApplicationComponent;
import home.oleg.dagger.di.components.DaggerApplicationComponent;

/**
 * Created by Oleg on 22.04.2017.
 */

public class DaggerApplication extends Application {

    private static ApplicationComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        if (BuildConfig.DEBUG) {
            AndroidDevMetrics.initWith(this);
        }

        component = DaggerApplicationComponent.create();
    }

    public static ApplicationComponent getComponent() {
        return component;
    }

}
