package home.oleg.dagger.di;

import android.content.Context;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Provider;

import home.oleg.dagger.di.components.ApplicationComponent;
import home.oleg.dagger.di.components.DaggerApplicationComponent;

/**
 * Created by Oleg on 08.05.2017.
 */

public class ComponentsHolder {

    private final Context context;

    @Inject
    Map<Class<?>, Provider<ActivityComponentBuilder>> builders;

    private Map<Class<?>, ActivityComponent> components;
    private ApplicationComponent appComponent;

    public ComponentsHolder(Context context) {
        this.context = context;
    }

    public void init() {
        appComponent = DaggerApplicationComponent.builder().bindContext(context).build();
        appComponent.inject(this);
        components = new HashMap<>();
    }

    public ApplicationComponent getApplicationComponent() {
        return appComponent;
    }

    public ActivityComponent getActivityComponent(Class<?> cls) {
        return getActivityComponent(cls, null);
    }

    @SuppressWarnings("unchecked")
    public ActivityComponent getActivityComponent(Class<?> cls, ActivityModule module) {
        ActivityComponent component = components.get(cls);
        if (component == null) {
            ActivityComponentBuilder builder = builders.get(cls).get();
            if (module != null) {
                 builder.module(module);
            }
            component = builder.build();
            components.put(cls, component);
        }
        return component;
    }

    public void releaseActivityComponent(Class<?> cls) {
        components.remove(cls);
    }

}