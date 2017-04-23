package home.oleg.dagger.di;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;

/**
 * Created by Oleg on 23.04.2017.
 */
@Qualifier
@Retention(RetentionPolicy.RUNTIME)
public @interface Prod {
}