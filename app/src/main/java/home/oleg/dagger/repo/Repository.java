package home.oleg.dagger.repo;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import home.oleg.dagger.entity.Item;

/**
 * Created by Oleg on 22.04.2017.
 */

public interface Repository<ITEM> {
    List<ITEM> getAll();

    ITEM get(String name);

    void remove(ITEM item);
}
