package home.oleg.dagger;

import android.app.Application;
import android.content.Context;

import home.oleg.dagger.di.ComponentsHolder;

/**
 * Created by Oleg on 22.04.2017.
 */

public class DaggerApplication extends Application {

    private ComponentsHolder componentsHolder;

    @Override
    public void onCreate() {
        super.onCreate();
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
