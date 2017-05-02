package home.oleg.dagger.di.components;

import com.google.common.util.concurrent.ListenableFuture;

import dagger.Component;
import dagger.producers.ProductionComponent;
import home.oleg.dagger.DetailActivity;
import home.oleg.dagger.HeavyExternalLibrary;
import home.oleg.dagger.di.modules.ApplictaionModule;
import home.oleg.dagger.di.modules.DetailModule;

/**
 * Created by Oleg on 01.05.2017.
 */
@ProductionComponent(modules = {DetailModule.class, ApplictaionModule.class})
public interface DetailComponent {
    ListenableFuture<HeavyExternalLibrary> heavyExternalLibraryListenableFuture();
}
