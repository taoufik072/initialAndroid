package fr.niji.tben_guiza.intproject.dagger.component;

import dagger.Component;
import fr.niji.tben_guiza.intproject.AdapterList;
import fr.niji.tben_guiza.intproject.dagger.modules.GithubServiceModule;
import fr.niji.tben_guiza.intproject.dagger.modules.HomeActivityModule;
import fr.niji.tben_guiza.intproject.dagger.scopes.ActivityHomeScope;
import fr.niji.tben_guiza.intproject.network.GithubService;

/**
 * Created by taoufikbenguiza on 27/03/2018.
 */
@ActivityHomeScope
@Component(modules = HomeActivityModule.class,dependencies = GithubApplicationComponent.class)
public interface HomeActivityComponent {

    AdapterList adapterList();

    GithubService githubService();

}
