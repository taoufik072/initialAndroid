package fr.taouf.sample_taouf;

import android.app.Application;

import fr.taouf.sample_taouf.dagger.DaggerGithubApplicationComponent;
import fr.taouf.sample_taouf.dagger.GithubApplicationComponent;
import fr.taouf.sample_taouf.dagger.modules.ContextModule;
import timber.log.Timber;

/**
 * Created by taoufikbenguiza on 23/03/2018.
 */

public class GithubApplication extends Application {


    @Override
    public void onCreate() {
        super.onCreate();

        Timber.plant(new Timber.DebugTree());

        GithubApplicationComponent component = DaggerGithubApplicationComponent.builder()
                .contextModule(new ContextModule(this))
                .build();



    }
}
