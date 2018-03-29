package fr.taouf.sample_taouf.network;

import java.util.List;

import fr.taouf.sample_taouf.network.response.Repo;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by taoufikbenguiza on 23/03/2018.
 */

public interface GithubService {

    @GET("users/{user}/repos")
    Call<List<Repo>> listRepos(@Path("user") String user);
}
