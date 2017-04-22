package home.oleg.dagger.mapping;

/**
 * Created by Oleg on 22.04.2017.
 */

public interface Mapper<FROM, TO> {
    TO map(FROM from);
}
