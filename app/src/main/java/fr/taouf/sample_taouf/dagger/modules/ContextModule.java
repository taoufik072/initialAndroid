package fr.taouf.sample_taouf.dagger.modules;

import android.content.Context;

import dagger.Module;
import dagger.Provides;
import fr.taouf.sample_taouf.dagger.GithubApplicationScope;

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
