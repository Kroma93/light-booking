package pl.whiteit.booking.light.common.annotation;

import pl.whiteit.booking.light.common.data.DataResources;
import pl.whiteit.booking.light.common.data.IdType;

import javax.inject.Qualifier;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Qualifier
@Retention(RUNTIME)
@Target({ TYPE, METHOD, FIELD, PARAMETER })
public @interface Identificator {
    IdType value();
}
