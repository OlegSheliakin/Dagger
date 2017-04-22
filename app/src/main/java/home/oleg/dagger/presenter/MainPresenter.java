package home.oleg.dagger.presenter;

import java.util.List;

import javax.inject.Inject;

import home.oleg.dagger.MainView;
import home.oleg.dagger.interactor.MainUseCase;
import home.oleg.dagger.interactor.UseCase;
import home.oleg.dagger.interactor.UseCaseObserver;
import home.oleg.dagger.view_model.ItemViewModel;

/**
 * Created by Oleg on 22.04.2017.
 */

public class MainPresenter implements Presenter<MainView>, UseCaseObserver<List<ItemViewModel>> {

    private final MainUseCase useCase;
    private MainView view;

    @Inject
    public MainPresenter(MainUseCase useCase) {
        this.useCase = useCase;
    }

    @Override
    public void attachView(MainView mainView) {
        this.view = mainView;
    }

    @Override
    public void created() {
        useCase.execute(this);
    }

    @Override
    public void onSuccess(List<ItemViewModel> itemViewModels) {
        view.showItems(itemViewModels);
    }

    @Override
    public void onError() {}
}



