package fr.niji.tben_guiza.intproject.network;

import java.util.List;

import fr.niji.tben_guiza.intproject.model.User;
import fr.niji.tben_guiza.intproject.network.response.Repo;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by taoufikbenguiza on 23/03/2018.
 */

public interface GithubService {

    @GET("users/{user}/repos")
    Call<List<User>> listRepos(@Path("user") String user);
}
