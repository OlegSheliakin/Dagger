package home.oleg.dagger.di;

import android.content.Context;
import android.support.annotation.NonNull;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Oleg on 22.04.2017.
 */

@Module
public class ApplictaionModule {

    private final Context context;

    public ApplictaionModule(Context context) {
        this.context = context;
    }

    @NonNull
    @Provides
    public Context provideContext() {
        return context;
    }

    @NonNull
    @Provides
    @Singleton
    String provideAppName(Context context) {
        return context.getPackageCodePath();
    }

}
