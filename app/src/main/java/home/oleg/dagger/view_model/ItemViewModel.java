package home.oleg.dagger.view_model;

/**
 * Created by Oleg on 22.04.2017.
 */

public class ItemViewModel {

    private final String name;
    private final String description;

    public ItemViewModel(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
