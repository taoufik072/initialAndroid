// Generated by dagger.internal.codegen.ComponentProcessor (https://google.github.io/dagger).
package fr.taouf.sample_taouf.dagger;

import android.content.Context;
import com.google.gson.Gson;
import com.squareup.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import fr.taouf.sample_taouf.dagger.component.GithubApplicationComponent;
import fr.taouf.sample_taouf.dagger.modules.ContextModule;
import fr.taouf.sample_taouf.dagger.modules.ContextModule_ContextFactory;
import fr.taouf.sample_taouf.dagger.modules.GithubServiceModule;
import fr.taouf.sample_taouf.dagger.modules.GithubServiceModule_GithubServiceFactory;
import fr.taouf.sample_taouf.dagger.modules.NetworkModule;
import fr.taouf.sample_taouf.dagger.modules.NetworkModule_CacheFactory;
import fr.taouf.sample_taouf.dagger.modules.NetworkModule_FileFactory;
import fr.taouf.sample_taouf.dagger.modules.NetworkModule_GsonFactory;
import fr.taouf.sample_taouf.dagger.modules.NetworkModule_LoggingInterceptorLoggingInterceptorFactory;
import fr.taouf.sample_taouf.dagger.modules.NetworkModule_OkHttpClientFactory;
import fr.taouf.sample_taouf.dagger.modules.NetworkModule_RetrofitFactory;
import fr.taouf.sample_taouf.dagger.modules.PicassoModule;
import fr.taouf.sample_taouf.dagger.modules.PicassoModule_OkHttp3DownloaderFactory;
import fr.taouf.sample_taouf.dagger.modules.PicassoModule_PicassoFactory;
import fr.taouf.sample_taouf.network.GithubService;
import java.io.File;
import javax.inject.Provider;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;

public final class DaggerGithubApplicationComponent implements GithubApplicationComponent {
  private Provider<HttpLoggingInterceptor> loggingInterceptorLoggingInterceptorProvider;

  private Provider<Context> contextProvider;

  private Provider<File> fileProvider;

  private Provider<Cache> cacheProvider;

  private Provider<OkHttpClient> okHttpClientProvider;

  private Provider<Gson> gsonProvider;

  private Provider<Retrofit> retrofitProvider;

  private Provider<GithubService> githubServiceProvider;

  private Provider<OkHttp3Downloader> okHttp3DownloaderProvider;

  private Provider<Picasso> picassoProvider;

  private DaggerGithubApplicationComponent(Builder builder) {
    assert builder != null;
    initialize(builder);
  }

  public static Builder builder() {
    return new Builder();
  }

  @SuppressWarnings("unchecked")
  private void initialize(final Builder builder) {

    this.loggingInterceptorLoggingInterceptorProvider =
        DoubleCheck.provider(
            NetworkModule_LoggingInterceptorLoggingInterceptorFactory.create(
                builder.networkModule));

    this.contextProvider =
        DoubleCheck.provider(ContextModule_ContextFactory.create(builder.contextModule));

    this.fileProvider =
        DoubleCheck.provider(
            NetworkModule_FileFactory.create(builder.networkModule, contextProvider));

    this.cacheProvider =
        DoubleCheck.provider(
            NetworkModule_CacheFactory.create(builder.networkModule, fileProvider));

    this.okHttpClientProvider =
        DoubleCheck.provider(
            NetworkModule_OkHttpClientFactory.create(
                builder.networkModule,
                loggingInterceptorLoggingInterceptorProvider,
                cacheProvider));

    this.gsonProvider =
        DoubleCheck.provider(NetworkModule_GsonFactory.create(builder.networkModule));

    this.retrofitProvider =
        DoubleCheck.provider(
            NetworkModule_RetrofitFactory.create(
                builder.networkModule, okHttpClientProvider, gsonProvider));

    this.githubServiceProvider =
        DoubleCheck.provider(
            GithubServiceModule_GithubServiceFactory.create(
                builder.githubServiceModule, retrofitProvider));

    this.okHttp3DownloaderProvider =
        DoubleCheck.provider(
            PicassoModule_OkHttp3DownloaderFactory.create(
                builder.picassoModule, okHttpClientProvider));

    this.picassoProvider =
        DoubleCheck.provider(
            PicassoModule_PicassoFactory.create(
                builder.picassoModule, contextProvider, okHttp3DownloaderProvider));
  }

  @Override
  public GithubService getGithubService() {
    return githubServiceProvider.get();
  }

  @Override
  public Picasso getPicasso() {
    return picassoProvider.get();
  }

  public static final class Builder {
    private NetworkModule networkModule;

    private ContextModule contextModule;

    private GithubServiceModule githubServiceModule;

    private PicassoModule picassoModule;

    private Builder() {}

    public GithubApplicationComponent build() {
      if (networkModule == null) {
        this.networkModule = new NetworkModule();
      }
      if (contextModule == null) {
        throw new IllegalStateException(ContextModule.class.getCanonicalName() + " must be set");
      }
      if (githubServiceModule == null) {
        this.githubServiceModule = new GithubServiceModule();
      }
      if (picassoModule == null) {
        this.picassoModule = new PicassoModule();
      }
      return new DaggerGithubApplicationComponent(this);
    }

    public Builder githubServiceModule(GithubServiceModule githubServiceModule) {
      this.githubServiceModule = Preconditions.checkNotNull(githubServiceModule);
      return this;
    }

    public Builder networkModule(NetworkModule networkModule) {
      this.networkModule = Preconditions.checkNotNull(networkModule);
      return this;
    }

    public Builder contextModule(ContextModule contextModule) {
      this.contextModule = Preconditions.checkNotNull(contextModule);
      return this;
    }

    public Builder picassoModule(PicassoModule picassoModule) {
      this.picassoModule = Preconditions.checkNotNull(picassoModule);
      return this;
    }
  }
}
