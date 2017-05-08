package home.oleg.dagger.interactor;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import home.oleg.dagger.datastore.Action;
import home.oleg.dagger.entity.Item;
import home.oleg.dagger.mapping.Mapper;
import home.oleg.dagger.repo.Repository;
import home.oleg.dagger.view_model.ItemViewModel;

/**
 * Created by Oleg on 22.04.2017.
 */

public class MainUseCase implements UseCase<List<ItemViewModel>>{

    private final Repository<Item> repository;
    private final Mapper<Item, ItemViewModel> mapper;
    private final Set<Action<List<Item>>> actions;

    public MainUseCase(Repository<Item> repository,
                       Mapper<Item, ItemViewModel> mapper,
                       Set<Action<List<Item>>> actions){
        this.repository = repository;
        this.mapper = mapper;
        this.actions = actions;
    }

    @Override
    public void execute(UseCaseObserver<List<ItemViewModel>> observer) {
        List<ItemViewModel> itemViewModels = new ArrayList<>();
        List<Item> items = repository.getAll();

        for (Action<List<Item>> action : actions) {
            action.perform(items);
        }

        for (Item item : items) {
            itemViewModels.add(mapper.map(item));
        }
        observer.onSuccess(itemViewModels);
    }
}

