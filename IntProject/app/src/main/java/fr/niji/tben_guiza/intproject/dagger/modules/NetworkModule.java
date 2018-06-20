package fr.niji.tben_guiza.intproject.dagger.modules;

import android.content.Context;
import android.support.annotation.NonNull;

import com.fatboyindustrial.gsonjodatime.DateTimeConverter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.joda.time.DateTime;

import java.io.File;

import dagger.Module;
import dagger.Provides;
import fr.niji.tben_guiza.intproject.dagger.scopes.GithubApplicationScope;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import timber.log.Timber;

/**
 * Created by taoufikbenguiza on 23/03/2018.
 */
@Module(includes = {ContextModule.class})
public class NetworkModule {

    @Provides
    @GithubApplicationScope
    public HttpLoggingInterceptor loggingInterceptorLoggingInterceptor() {

        HttpLoggingInterceptor httpLoggingInterceptor;
        httpLoggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(@NonNull String message) {
                Timber.i(message);
            }
        });
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
        return httpLoggingInterceptor;


    }

    @Provides
    @GithubApplicationScope
    public Cache cache(File fileCache) {
        return new Cache(fileCache, 10 * 1024 * 1024); //10MB cache
    }

    @Provides
    @GithubApplicationScope
    public File file(Context context) {
        return new File(context.getCacheDir(), "okhttp_cache");
    }

    @Provides
    @GithubApplicationScope
    public OkHttpClient okHttpClient(HttpLoggingInterceptor loggingInterceptor, Cache cache) {

        return new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .cache(cache)
                .build();
    }

    @Provides
    @GithubApplicationScope
    public Gson gson() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(DateTime.class, new DateTimeConverter());
        return gsonBuilder.create();
    }

    @Provides
    @GithubApplicationScope
    public Retrofit retrofit(OkHttpClient okHttpClient, Gson gson) {

        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(okHttpClient)
                .baseUrl("https://api.github.com/")
                .build();
    }
}
