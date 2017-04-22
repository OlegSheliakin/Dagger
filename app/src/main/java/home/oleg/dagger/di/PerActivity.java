package home.oleg.dagger.di;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by Oleg on 22.04.2017.
 */
@Scope
@Documented
@Retention(RUNTIME)
public @interface PerActivity {
}
