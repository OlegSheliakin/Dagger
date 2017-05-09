package home.oleg.dagger.presenter;

import java.util.List;

import javax.inject.Inject;

import home.oleg.dagger.di.scopes.PerActivity;
import home.oleg.dagger.view.MainView;
import home.oleg.dagger.interactor.UseCase;
import home.oleg.dagger.interactor.UseCaseObserver;
import home.oleg.dagger.view_model.ItemViewModel;

/**
 * Created by Oleg on 22.04.2017.
 */
@PerActivity
public class MainPresenter implements Presenter<MainView>, UseCaseObserver<List<ItemViewModel>> {

    private final UseCase<List<ItemViewModel>> useCase;
    private MainView view;

    @Inject
    public MainPresenter(UseCase<List<ItemViewModel>> useCase) {
        this.useCase = useCase;
    }

    @Override
    public void attachView(MainView mainView) {
        this.view = mainView;
    }

    @Override
    public void fetchItems() {
        useCase.execute(this);
    }

    @Override
    public void onSuccess(List<ItemViewModel> itemViewModels) {
        view.showItems(itemViewModels);
    }

    @Override
    public void onError() {}
}



