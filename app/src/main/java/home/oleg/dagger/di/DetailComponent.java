package home.oleg.dagger.di;

import com.google.common.util.concurrent.ListenableFuture;

import dagger.producers.ProductionComponent;
import home.oleg.dagger.DetailActivity;
import home.oleg.dagger.entity.Item;

/**
 * Created by Oleg on 01.05.2017.
 */
@ProductionComponent(modules = DetailModule.class)
public interface DetailComponent {
    ListenableFuture<Item> item();
   //void inject(DetailActivity detailActivity);
}
