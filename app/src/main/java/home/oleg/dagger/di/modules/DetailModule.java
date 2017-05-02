package home.oleg.dagger.di.modules;

import java.util.concurrent.Callable;

import dagger.Lazy;
import dagger.Module;
import dagger.Provides;
import home.oleg.dagger.HeavyExternalLibrary;
import home.oleg.dagger.di.modules.ApplictaionModule;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Oleg on 01.05.2017.
 */
@Module(includes = ApplictaionModule.class)
public class DetailModule {

    @Provides
    public HeavyExternalLibrary provideHeavyLibrary() {
        return new HeavyExternalLibrary();
    }

    @Provides
    public Single<HeavyExternalLibrary> produceName(final Lazy<HeavyExternalLibrary> heavyExternalLibraryLazy) {
        return Single.fromCallable(new Callable<HeavyExternalLibrary>() {
            @Override
            public HeavyExternalLibrary call() throws Exception {
                HeavyExternalLibrary heavyExternalLibrary = heavyExternalLibraryLazy.get();
                heavyExternalLibrary.init();
                return heavyExternalLibrary;
            }
        }).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread());
    }

}
