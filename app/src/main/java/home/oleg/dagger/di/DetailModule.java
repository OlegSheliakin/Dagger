package home.oleg.dagger.di;

import dagger.producers.ProducerModule;
import dagger.producers.Produces;
import home.oleg.dagger.entity.Item;

/**
 * Created by Oleg on 01.05.2017.
 */
@ProducerModule(includes = ApplictaionModule.class)
public class DetailModule {

    @Produces
    public Item provideItem() {
        try {
            Thread.sleep(5000);
            return new Item("item", "async item");
        } catch (InterruptedException e) {
            e.printStackTrace();
            return null;
        }
    }

}
