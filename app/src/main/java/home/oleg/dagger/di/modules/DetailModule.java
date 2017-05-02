package home.oleg.dagger.di.modules;

import com.google.common.util.concurrent.ListenableFuture;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import dagger.Lazy;
import dagger.Module;
import dagger.Provides;
import dagger.producers.ProducerModule;
import dagger.producers.Produces;
import dagger.producers.Production;
import dagger.producers.ProductionComponent;
import home.oleg.dagger.HeavyExternalLibrary;
import home.oleg.dagger.di.modules.ApplictaionModule;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Oleg on 01.05.2017.
 */
@ProducerModule(includes = ApplictaionModule.class)
public class DetailModule {

    @Produces
    public HeavyExternalLibrary produceName() {
        HeavyExternalLibrary heavyExternalLibrary = new HeavyExternalLibrary();
        heavyExternalLibrary.init();
        return heavyExternalLibrary;
    }
}
