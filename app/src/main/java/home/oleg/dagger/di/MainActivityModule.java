package home.oleg.dagger.di;

import android.support.annotation.NonNull;

import java.util.List;
import java.util.Map;

import dagger.Module;
import dagger.Provides;
import home.oleg.dagger.MainView;
import home.oleg.dagger.entity.Item;
import home.oleg.dagger.interactor.MainUseCase;
import home.oleg.dagger.interactor.UseCase;
import home.oleg.dagger.mapping.Mapper;
import home.oleg.dagger.presenter.MainPresenter;
import home.oleg.dagger.presenter.Presenter;
import home.oleg.dagger.repo.Repository;
import home.oleg.dagger.view_model.ItemViewModel;

/**
 * Created by Oleg on 22.04.2017.
 */

@Module
public class MainActivityModule {

    @NonNull
    @Provides
    public Presenter<MainView> providePresenter(UseCase<List<ItemViewModel>> useCase){
        return new MainPresenter(useCase);
    }

    @NonNull
    @Provides
    public UseCase<List<ItemViewModel>> provideUseCase(Repository<Item> repository, Mapper<Item, ItemViewModel> mapper){
        return new MainUseCase(repository, mapper);
    }

}
