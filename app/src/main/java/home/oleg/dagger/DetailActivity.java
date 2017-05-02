package home.oleg.dagger;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;

import javax.inject.Inject;

import home.oleg.dagger.di.components.DaggerDetailComponent;
import home.oleg.dagger.di.modules.ApplictaionModule;
import io.reactivex.Single;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;

public class DetailActivity extends AppCompatActivity {

    private HeavyExternalLibrary heavyExternalLibrary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ListenableFuture<HeavyExternalLibrary> heavyExternalLibraryListenableFuture = DaggerDetailComponent.builder()
                .build()
                .heavyExternalLibraryListenableFuture();
        Futures.addCallback(heavyExternalLibraryListenableFuture, new FutureCallback<HeavyExternalLibrary>() {
            @Override
            public void onSuccess(HeavyExternalLibrary result) {
                DetailActivity.this.heavyExternalLibrary = result;
                result.callMethod();
            }

            @Override
            public void onFailure(Throwable t) {
                t.printStackTrace();
            }
        });

    }
}
