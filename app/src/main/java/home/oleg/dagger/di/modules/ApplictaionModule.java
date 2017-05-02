package home.oleg.dagger.di.modules;

import android.content.Context;
import android.support.annotation.NonNull;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.producers.Production;

/**
 * Created by Oleg on 22.04.2017.
 */

@Module
public class ApplictaionModule {

    @Provides
    @Production
    public Executor executor() {
        return Executors.newSingleThreadExecutor();
    }
}
