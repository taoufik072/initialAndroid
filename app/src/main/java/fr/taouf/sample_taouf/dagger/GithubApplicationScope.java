package fr.taouf.sample_taouf.dagger;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by taoufikbenguiza on 23/03/2018.
 */
@Scope
@Retention(RetentionPolicy.CLASS)
public @interface GithubApplicationScope { }
