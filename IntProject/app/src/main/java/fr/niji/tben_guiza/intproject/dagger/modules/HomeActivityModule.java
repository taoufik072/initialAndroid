package fr.niji.tben_guiza.intproject.dagger.modules;

import android.widget.Adapter;

import com.squareup.picasso.Picasso;

import dagger.Module;
import dagger.Provides;
import fr.niji.tben_guiza.intproject.AdapterList;
import fr.niji.tben_guiza.intproject.MainActivity;
import fr.niji.tben_guiza.intproject.dagger.scopes.ActivityHomeScope;

@Module
public class HomeActivityModule {

    private final MainActivity mainActivity;

    public HomeActivityModule(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    @Provides
    @ActivityHomeScope
    public AdapterList adapterList(Picasso picasso) {
        return new AdapterList(mainActivity, picasso);
    }
}
