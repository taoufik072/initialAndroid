package fr.niji.tben_guiza.intproject.dagger.modules;

import dagger.Module;
import dagger.Provides;
import fr.niji.tben_guiza.intproject.dagger.scopes.GithubApplicationScope;
import fr.niji.tben_guiza.intproject.network.GithubService;
import retrofit2.Retrofit;

/**
 * Created by taoufikbenguiza on 23/03/2018.
 */
@Module(includes = NetworkModule.class)
public class GithubServiceModule {

    @Provides
    @GithubApplicationScope
    public GithubService githubService(Retrofit githubRetrofit) {
        return githubRetrofit.create(GithubService.class);
    }


}
