package pl.whiteit.booking.light.room.service;

import pl.whiteit.booking.light.booking.model.Booking;
import pl.whiteit.booking.light.room.model.Room;

import java.util.Date;
import java.util.Objects;
import java.util.Optional;

public class CheckRoomAvailableService {

    public boolean checkAvailable(Room room, Date dateFrom) {
        if (Objects.nonNull(room.bookingList)) {
            Optional<Booking> bookingNotAvailable = room.bookingList.stream().filter(booking ->
                    (booking.dateFrom.before(dateFrom) || booking.dateFrom.equals(dateFrom))
                            && (booking.dateTo.after(dateFrom) || booking.dateTo.equals(dateFrom))).findAny();
            return !bookingNotAvailable.isPresent();
        }
        return true;
    }
}
