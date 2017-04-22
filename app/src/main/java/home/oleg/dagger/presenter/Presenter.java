package home.oleg.dagger.presenter;

/**
 * Created by Oleg on 22.04.2017.
 */

public interface Presenter<VIEW> {
    void attachView(VIEW view);
    void created();
}