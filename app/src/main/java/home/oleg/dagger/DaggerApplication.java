package home.oleg.dagger;

import android.app.Application;
import android.content.Context;

import com.frogermcs.androiddevmetrics.AndroidDevMetrics;

import home.oleg.dagger.di.ComponentsHolder;

/**
 * Created by Oleg on 22.04.2017.
 */

public class DaggerApplication extends Application {

    private ComponentsHolder componentsHolder;

    @Override
    public void onCreate() {
        super.onCreate();
        if (BuildConfig.DEBUG) {
            AndroidDevMetrics.initWith(this);
        }
        componentsHolder = new ComponentsHolder(this);
        componentsHolder.init();
    }

    public static DaggerApplication getApp(Context context) {
        return (DaggerApplication)context.getApplicationContext();
    }

    public ComponentsHolder getComponentsHolder() {
        return componentsHolder;
    }

}
