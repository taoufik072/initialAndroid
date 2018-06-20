package fr.niji.tben_guiza.intproject;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import java.util.List;

import fr.niji.tben_guiza.intproject.dagger.component.DaggerHomeActivityComponent;
import fr.niji.tben_guiza.intproject.dagger.component.HomeActivityComponent;
import fr.niji.tben_guiza.intproject.dagger.modules.HomeActivityModule;
import fr.niji.tben_guiza.intproject.model.User;
import fr.niji.tben_guiza.intproject.network.GithubService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    HomeActivityComponent homeActivityComponent;

    Call<List<User>> repoCall;

    AdapterList adapterList;
    GithubService githubService;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        homeActivityComponent = DaggerHomeActivityComponent.builder()
                .homeActivityModule(new HomeActivityModule(this))
                .githubApplicationComponent(GithubApplication.get(this).getComponent())
                .build();

        adapterList = homeActivityComponent.adapterList();
        githubService = homeActivityComponent.githubService();

        repoCall = githubService.listRepos("taoufik072");
        repoCall.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                adapterList.swapData(response.body());
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {

            }
        });


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (repoCall != null)
            repoCall.cancel();
    }
}
