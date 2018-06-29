package pl.whiteit.booking.light.common.annotation;

import pl.whiteit.booking.light.common.data.DataResources;

import java.lang.annotation.Annotation;

public class ResourcesAnnotationBuilder {

    public static Annotation create(final DataResources type) {
        return new Resources() {

            @Override
            public Class<? extends Annotation> annotationType() {
                return Resources.class;
            }

            @Override
            public DataResources value() {
                return type;
            }

        };
    }

}
