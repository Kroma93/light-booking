package pl.whiteit.booking.light.room.validator;

import pl.whiteit.booking.light.booking.model.Booking;
import pl.whiteit.booking.light.common.exception.ValidationException;
import pl.whiteit.booking.light.common.validator.Validator;
import pl.whiteit.booking.light.room.model.Room;
import pl.whiteit.booking.light.room.service.CheckRoomAvailableService;
import pl.whiteit.booking.light.room.service.RoomCrudService;

import javax.inject.Inject;
import java.util.Objects;

public class AddBookingValidator implements Validator<Booking> {

    @Inject
    private BookingValidator bookingValidator;

    @Inject
    private RoomCrudService roomCrudService;

    @Inject
    private CheckRoomAvailableService checkRoomAvailableService;

    @Override
    public void valid(Booking objectToValid) throws ValidationException {
        bookingValidator.valid(objectToValid);
        if(!existRoom(objectToValid)){
            throw new ValidationException("Nie znaleziono pokoju o takim identyfikatorze");
        }
        if(!isRoomAvailable(objectToValid)){
            throw new ValidationException("W tym terminie pokój jest już zarezerwowany");
        }
    }

    private boolean existRoom(Booking objectToValid){
        return Objects.nonNull(roomCrudService.getRoomById(objectToValid.room.id));
    }

    private boolean isRoomAvailable(Booking objectToValid){
        Room room = roomCrudService.getRoomById(objectToValid.room.id);
        return checkRoomAvailableService.checkAvailable(room,objectToValid.dateFrom);
    }
}
