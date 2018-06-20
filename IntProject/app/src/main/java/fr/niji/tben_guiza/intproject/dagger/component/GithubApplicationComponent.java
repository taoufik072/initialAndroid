package fr.niji.tben_guiza.intproject.dagger.component;

import com.squareup.picasso.Picasso;

import dagger.Component;
import fr.niji.tben_guiza.intproject.dagger.scopes.GithubApplicationScope;
import fr.niji.tben_guiza.intproject.dagger.modules.GithubServiceModule;
import fr.niji.tben_guiza.intproject.dagger.modules.PicassoModule;
import fr.niji.tben_guiza.intproject.network.GithubService;

/**
 * Created by taoufikbenguiza on 23/03/2018.
 */
@GithubApplicationScope
@Component(modules = {GithubServiceModule.class, PicassoModule.class})
public interface GithubApplicationComponent {

    GithubService getGithubService();

    Picasso getPicasso();

}
