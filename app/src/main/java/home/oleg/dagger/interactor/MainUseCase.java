package home.oleg.dagger.interactor;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import home.oleg.dagger.entity.Item;
import home.oleg.dagger.mapping.ItemMapper;
import home.oleg.dagger.mapping.Mapper;
import home.oleg.dagger.repo.ItemRepository;
import home.oleg.dagger.repo.Repository;
import home.oleg.dagger.view_model.ItemViewModel;

/**
 * Created by Oleg on 22.04.2017.
 */

public class MainUseCase implements UseCase<List<ItemViewModel>>{

    private final Repository<Item> repository;
    private final Mapper<Item, ItemViewModel> mapper;

    public MainUseCase(Repository<Item> repository, Mapper<Item, ItemViewModel> mapper){
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public void execute(UseCaseObserver<List<ItemViewModel>> observer) {
        List<ItemViewModel> itemViewModels = new ArrayList<>();
        repository.getAll().forEach(item -> itemViewModels.add(mapper.map(item)));
        observer.onSuccess(itemViewModels);
    }
}

