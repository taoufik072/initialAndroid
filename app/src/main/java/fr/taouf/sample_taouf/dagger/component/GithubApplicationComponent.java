package fr.taouf.sample_taouf.dagger.component;

import com.squareup.picasso.Picasso;

import dagger.Component;
import fr.taouf.sample_taouf.dagger.GithubApplicationScope;
import fr.taouf.sample_taouf.dagger.modules.GithubServiceModule;
import fr.taouf.sample_taouf.dagger.modules.PicassoModule;
import fr.taouf.sample_taouf.network.GithubService;

/**
 * Created by taoufikbenguiza on 23/03/2018.
 */
@GithubApplicationScope
@Component(modules = {GithubServiceModule.class, PicassoModule.class})
public interface GithubApplicationComponent {

    GithubService getGithubService();

    Picasso getPicasso();

}
