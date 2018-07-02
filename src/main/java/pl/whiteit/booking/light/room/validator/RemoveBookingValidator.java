package pl.whiteit.booking.light.room.validator;

import pl.whiteit.booking.light.common.exception.ValidationException;
import pl.whiteit.booking.light.common.validator.Validator;
import pl.whiteit.booking.light.room.dto.RemoveBookingRoomDto;
import pl.whiteit.booking.light.room.service.RoomCrudService;

import javax.inject.Inject;
import java.util.Objects;

public class RemoveBookingValidator implements Validator<RemoveBookingRoomDto> {

    @Inject
    private RoomCrudService roomCrudService;

    @Override
    public void valid(RemoveBookingRoomDto removeBookingRoomDto) throws ValidationException {
        if(Objects.isNull(removeBookingRoomDto.roomId)){
            throw new ValidationException("Błędny identyfikator pokoju");
        }
        if(Objects.isNull(removeBookingRoomDto.bookingId)){
            throw new ValidationException("Błędny identyfikator rezerwacji");
        }
        if (!existRoom(removeBookingRoomDto)) {
            throw new ValidationException("Nie znaleziono pokoju o takim identyfikatorze");
        }

    }

    private boolean existRoom(RemoveBookingRoomDto removeBookingRoomDto) {
        return Objects.nonNull(roomCrudService.getRoomById(removeBookingRoomDto.roomId));
    }

}
