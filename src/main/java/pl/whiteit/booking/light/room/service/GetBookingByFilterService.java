package pl.whiteit.booking.light.room.service;

import pl.whiteit.booking.light.booking.model.Booking;
import pl.whiteit.booking.light.room.dto.BookingFilter;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Stateless
public class GetBookingByFilterService {

    @Inject
    private RoomCrudService roomCrudService;

    public Optional<Booking> get(BookingFilter bookingFilter){
        List<Booking> bookingList = roomCrudService.getRoomById(bookingFilter.roomId).bookingList;
        if(Objects.nonNull(bookingList)) {
            return bookingList.stream().filter(booking -> booking.id.equals(bookingFilter.bookingId)).findAny();
        }
        return Optional.empty();
    }
}
