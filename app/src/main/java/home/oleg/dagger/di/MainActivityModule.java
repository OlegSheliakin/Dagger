package home.oleg.dagger.di;

import android.support.annotation.NonNull;
import android.util.Log;

import java.util.List;
import java.util.Set;

import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoSet;
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

@Module
public class MainActivityModule {

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


