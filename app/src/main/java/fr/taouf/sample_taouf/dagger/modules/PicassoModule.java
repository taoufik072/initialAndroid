package fr.taouf.sample_taouf.dagger.modules;

import android.content.Context;

import com.squareup.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import dagger.Module;
import dagger.Provides;
import fr.taouf.sample_taouf.dagger.GithubApplicationScope;
import okhttp3.OkHttpClient;

/**
 * Created by taoufikbenguiza on 23/03/2018.
 */
@Module(includes = {ContextModule.class, NetworkModule.class})

public class PicassoModule {

    @Provides
    @GithubApplicationScope
    public Picasso picasso(Context context, OkHttp3Downloader okHttp3Downloader) {
        return new Picasso.Builder(context)
                .downloader(okHttp3Downloader)
                .build();
    }

    @Provides
    @GithubApplicationScope
    public OkHttp3Downloader okHttp3Downloader(OkHttpClient okHttpClient) {
        return new OkHttp3Downloader(okHttpClient);
    }
}
