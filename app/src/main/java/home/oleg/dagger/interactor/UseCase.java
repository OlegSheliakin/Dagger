package home.oleg.dagger.interactor;

/**
 * Created by Oleg on 22.04.2017.
 */

public interface UseCase<DATA> {
    void execute(UseCaseObserver<DATA> observer);
}
