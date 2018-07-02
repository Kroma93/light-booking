package pl.whiteit.booking.light.room.validator;

import pl.whiteit.booking.light.booking.model.Booking;
import pl.whiteit.booking.light.common.exception.ValidationException;
import pl.whiteit.booking.light.common.validator.Validator;

import java.util.Objects;

public class BookingValidator implements Validator<Booking> {

    @Override
    public void valid(Booking booking) throws ValidationException {
        if(Objects.isNull(booking)){
            throw new ValidationException("Niepoprawny format danych");
        }
        if(Objects.isNull(booking.dateFrom)){
            throw new ValidationException("Brak daty początku rezerwacji");
        }
        if(Objects.isNull(booking.dateTo)){
            throw new ValidationException("Brak daty końca rezerwacji");
        }
        if(Objects.isNull(booking.email)){
            throw new ValidationException("Brak adresu e-mail");
        }
        if(Objects.isNull(booking.numberPeople) || booking.numberPeople < 1){
            throw new ValidationException("Błedna ilość osób");
        }
        if(Objects.isNull(booking.room) || Objects.isNull(booking.room.id)){
            throw new ValidationException("Brak wybranego pokoju");
        }
    }
}
