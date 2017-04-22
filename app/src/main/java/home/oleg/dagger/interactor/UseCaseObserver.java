package home.oleg.dagger.interactor;

/**
 * Created by Oleg on 22.04.2017.
 */

public interface UseCaseObserver<DATA> {
    void onSuccess(DATA data);
    void onError();
}