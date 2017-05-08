package home.oleg.dagger;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

import home.oleg.dagger.datastore.HeavyExternalLibrary;
import home.oleg.dagger.di.BindableActivity;
import home.oleg.dagger.di.components.DetailComponent;
import io.reactivex.Single;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;

public class DetailActivity extends AppCompatActivity implements BindableActivity {

    @Inject Single<HeavyExternalLibrary> heavyExternalLibrarySingle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        DaggerApplication.getApp(this)
                .getComponentsHolder()
                .getActivityComponent(this, DetailComponent.class).inject(this);
        System.out.println(DaggerApplication.getApp(this).getComponentsHolder().getAll().toString());

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

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (isFinishing()) {
            DaggerApplication.getApp(this).getComponentsHolder().releaseActivityComponent(this);
        }
    }
}
