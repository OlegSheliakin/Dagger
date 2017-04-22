package home.oleg.dagger.repo;

import java.util.List;

/**
 * Created by Oleg on 22.04.2017.
 */

public interface Repository<ITEM> {
    List<ITEM> getAll();
}
