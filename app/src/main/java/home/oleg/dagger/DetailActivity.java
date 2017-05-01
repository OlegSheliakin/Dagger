package home.oleg.dagger;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;

import javax.inject.Inject;

import dagger.producers.Producer;
import home.oleg.dagger.di.ApplictaionModule;
import home.oleg.dagger.di.DaggerDetailComponent;
import home.oleg.dagger.entity.Item;

public class DetailActivity extends AppCompatActivity {

    @Inject Producer<ListenableFuture<Item>> listenableFutureProducer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

      /*  ListenableFuture<Item> itemListenableFuture = DaggerDetailComponent.builder().applictaionModule(new ApplictaionModule(this)).build().item();

        Futures.addCallback(itemListenableFuture, new FutureCallback<Item>() {
            @Override
            public void onSuccess(Item result) {
                System.out.println(result);
            }

            @Override
            public void onFailure(Throwable t) {
                t.printStackTrace();
            }
        });*/

    }
}
