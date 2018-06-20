package fr.niji.tben_guiza.intproject;

import android.app.Activity;
import android.app.Application;

import fr.niji.tben_guiza.intproject.dagger.component.DaggerGithubApplicationComponent;
import fr.niji.tben_guiza.intproject.dagger.component.GithubApplicationComponent;
import fr.niji.tben_guiza.intproject.dagger.modules.ContextModule;
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

         component = DaggerGithubApplicationComponent.builder()
                .contextModule(new ContextModule(this))
                .build();



        Timber.d("hello %s", component.getPicasso());

        Timber.d("hello2 %s", component.getPicasso());

    }

    public GithubApplicationComponent getComponent() {
        return component;
    }
}
