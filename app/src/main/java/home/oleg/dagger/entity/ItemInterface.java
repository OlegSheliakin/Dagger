package home.oleg.dagger.entity;

/**
 * Created by Oleg on 01.05.2017.
 */

public interface ItemInterface extends Comparable<ItemInterface>{
    String getName();
    boolean isExpired();
}
