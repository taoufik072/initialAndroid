package fr.niji.tben_guiza.intproject.dagger.modules;

import android.content.Context;

import dagger.Module;
import dagger.Provides;
import fr.niji.tben_guiza.intproject.dagger.scopes.GithubApplicationScope;

/**
 * Created by taoufikbenguiza on 23/03/2018.
 */
@Module
public class ContextModule {

    private Context context;

    public ContextModule(Context context) {
        this.context = context;
    }

    @Provides
    @GithubApplicationScope
    public Context context() {
        return context;
    }
}
