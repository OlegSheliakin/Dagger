package home.oleg.dagger;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

import home.oleg.dagger.di.components.DaggerDetailComponent;
import io.reactivex.Single;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;

public class DetailActivity extends AppCompatActivity {

    @Inject Single<HeavyExternalLibrary> heavyExternalLibrarySingle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        DaggerDetailComponent.builder().build().inject(this);
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
