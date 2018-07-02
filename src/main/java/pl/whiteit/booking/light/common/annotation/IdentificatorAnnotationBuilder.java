package pl.whiteit.booking.light.common.annotation;

import pl.whiteit.booking.light.common.data.IdType;

import java.lang.annotation.Annotation;

public class IdentificatorAnnotationBuilder {

    public static Annotation create(final IdType type) {
        return new Identificator() {

            @Override
            public Class<? extends Annotation> annotationType() {
                return Identificator.class;
            }

            @Override
            public IdType value() {
                return type;
            }

        };
    }

}
