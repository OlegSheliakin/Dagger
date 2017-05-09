package home.oleg.dagger.di.modules;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;

import java.util.List;
import java.util.Set;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import home.oleg.dagger.datastore.Action;
import home.oleg.dagger.R;
import home.oleg.dagger.di.BindableActivity;
import home.oleg.dagger.di.scopes.PerActivity;
import home.oleg.dagger.entity.Item;
import home.oleg.dagger.interactor.MainUseCase;
import home.oleg.dagger.interactor.UseCase;
import home.oleg.dagger.mapping.Mapper;
import home.oleg.dagger.presenter.MainPresenter;
import home.oleg.dagger.presenter.Presenter;
import home.oleg.dagger.repo.Repository;
import home.oleg.dagger.view.MainView;
import home.oleg.dagger.view_model.ItemViewModel;

/**
 * Created by Oleg on 22.04.2017.
 */

@Module(includes = ActionModule.class)
public abstract class MainActivityModule {

    @NonNull
    @Provides
    @PerActivity
    public static Drawable provideAppIcon(Context context) {
        return ContextCompat.getDrawable(context, R.mipmap.ic_launcher);
    }

    @NonNull
    @Binds
    @PerActivity
    public abstract Presenter<MainView> providePresenter(MainPresenter presenter);

    @NonNull
    @Binds
    @PerActivity
    public abstract UseCase<List<ItemViewModel>> provideUseCase(MainUseCase useCase);

}


