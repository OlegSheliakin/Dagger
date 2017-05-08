package home.oleg.dagger.di.modules;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;

import java.util.List;
import java.util.Set;

import dagger.Module;
import dagger.Provides;
import home.oleg.dagger.datastore.Action;
import home.oleg.dagger.R;
import home.oleg.dagger.di.ActivityModule;
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
public class MainActivityModule implements ActivityModule {

    @NonNull
    @Provides
    @PerActivity
    public Drawable provideAppIcon(Context context) {
        return ContextCompat.getDrawable(context, R.mipmap.ic_launcher);
    }

    @NonNull
    @Provides
    @PerActivity
    public Presenter<MainView> providePresenter(UseCase<List<ItemViewModel>> useCase) {
        return new MainPresenter(useCase);
    }

    @NonNull
    @Provides
    @PerActivity
    public UseCase<List<ItemViewModel>> provideUseCase(Repository<Item> repository, Mapper<Item,
            ItemViewModel> mapper, Set<Action<List<Item>>> actions) {
        return new MainUseCase(repository, mapper, actions);
    }

}


