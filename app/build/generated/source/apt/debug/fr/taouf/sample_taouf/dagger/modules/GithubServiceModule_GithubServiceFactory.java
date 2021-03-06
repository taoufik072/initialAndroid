// Generated by dagger.internal.codegen.ComponentProcessor (https://google.github.io/dagger).
package fr.taouf.sample_taouf.dagger.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import fr.taouf.sample_taouf.network.GithubService;
import javax.inject.Provider;
import retrofit2.Retrofit;

public final class GithubServiceModule_GithubServiceFactory implements Factory<GithubService> {
  private final GithubServiceModule module;

  private final Provider<Retrofit> githubRetrofitProvider;

  public GithubServiceModule_GithubServiceFactory(
      GithubServiceModule module, Provider<Retrofit> githubRetrofitProvider) {
    assert module != null;
    this.module = module;
    assert githubRetrofitProvider != null;
    this.githubRetrofitProvider = githubRetrofitProvider;
  }

  @Override
  public GithubService get() {
    return Preconditions.checkNotNull(
        module.githubService(githubRetrofitProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<GithubService> create(
      GithubServiceModule module, Provider<Retrofit> githubRetrofitProvider) {
    return new GithubServiceModule_GithubServiceFactory(module, githubRetrofitProvider);
  }
}
