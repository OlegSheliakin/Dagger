package home.oleg.dagger.datastore;

import java.util.List;

import io.reactivex.Observable;
import okhttp3.Response;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Oleg on 01.05.2017.
 */
public interface GithubApiService {

    @GET("/users/{username}")
    Observable<Response> getUser(
            @Path("username") String username
    );

    @GET("/users/{username}/repos")
    Observable<List<Response>> getUsersRepositories(
            @Path("username") String username
    );
}