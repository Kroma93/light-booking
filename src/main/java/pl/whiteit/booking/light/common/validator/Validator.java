package pl.whiteit.booking.light.common.validator;

import pl.whiteit.booking.light.common.exception.ValidationException;

public interface Validator<T> {

    void valid(T objectToValid) throws ValidationException;
}
