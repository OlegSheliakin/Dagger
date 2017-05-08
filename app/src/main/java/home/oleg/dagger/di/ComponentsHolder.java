package home.oleg.dagger.di;

import android.content.Context;
import android.support.annotation.NonNull;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Provider;

import home.oleg.dagger.DaggerApplication;
import home.oleg.dagger.di.components.ApplicationComponent;
import home.oleg.dagger.di.components.DaggerApplicationComponent;
import home.oleg.dagger.di.components.DetailComponent;

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

    public <T extends BindableActivity, C extends ActivityComponent> C getActivityComponent(@NonNull T activity, @NonNull Class<C> cls) {
        ActivityComponent component = components.get(activity.getClass());
        if (component == null) {
            ActivityComponentBuilder builder = builders.get(activity.getClass()).get();
            builder.activity(activity);
            component = builder.build();
            components.put(activity.getClass(), component);
        }
        return as(cls, component);
    }

    private <T extends ActivityComponent> T as( Class<T> cls, ActivityComponent component) {
        return cls.cast(component);
    }

    public void releaseActivityComponent(Class<?> cls) {
        components.put(cls, null);

    }

}