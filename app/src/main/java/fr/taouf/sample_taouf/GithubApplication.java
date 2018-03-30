package fr.taouf.sample_taouf;

import android.app.Activity;
import android.app.Application;

import fr.taouf.sample_taouf.dagger.DaggerGithubApplicationComponent;
import fr.taouf.sample_taouf.dagger.component.GithubApplicationComponent;
import fr.taouf.sample_taouf.dagger.modules.ContextModule;
import timber.log.Timber;

/**
 * Created by taoufikbenguiza on 23/03/2018.
 */

public class GithubApplication extends Application {

    GithubApplicationComponent component;

    public static GithubApplication get(Activity activity) {
        return (GithubApplication) activity.getApplication();
    }


    @Override
    public void onCreate() {
        super.onCreate();

        Timber.plant(new Timber.DebugTree());

        GithubApplicationComponent component = DaggerGithubApplicationComponent.builder()
                .contextModule(new ContextModule(this))
                .build();



        Timber.d("hello %s", component.getPicasso());

        Timber.d("hello2 %s", component.getPicasso());

    }

    public GithubApplicationComponent component() {
        return component;
    }
}
