package home.oleg.dagger;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasDispatchingFragmentInjector;
import home.oleg.dagger.datastore.HeavyExternalLibrary;
import home.oleg.dagger.di.BindableActivity;
import home.oleg.dagger.di.components.DetailComponent;
import io.reactivex.Single;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;

public class DetailActivity extends AppCompatActivity {

    @Inject Single<HeavyExternalLibrary> heavyExternalLibrarySingle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        heavyExternalLibrarySingle.subscribe(new Consumer<HeavyExternalLibrary>() {
            @Override
            public void accept(@NonNull HeavyExternalLibrary heavyExternalLibrary) throws Exception {
                heavyExternalLibrary.callMethod();
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(@NonNull Throwable throwable) throws Exception {
                throwable.printStackTrace();
            }
        });
    }

}