package pl.whiteit.booking.light.room.service;

import pl.whiteit.booking.light.booking.model.Booking;
import pl.whiteit.booking.light.common.exception.ValidationException;
import pl.whiteit.booking.light.room.dto.BookingFilter;
import pl.whiteit.booking.light.room.dto.RemoveBookingRoomDto;
import pl.whiteit.booking.light.room.validator.RemoveBookingValidator;

import javax.inject.Inject;
import java.util.Optional;

public class RemoveBookingService {

    @Inject
    private GetBookingByFilterService getBookingByFilterService;

    @Inject
    private RemoveBookingValidator removeBookingValidator;

    @Inject
    private RoomCrudService roomCrudService;

    public Booking removeBooking(RemoveBookingRoomDto removeBookingRoomDto) throws ValidationException {
        removeBookingValidator.valid(removeBookingRoomDto);
        Optional<Booking> bookingToRemove = getBookingToRemove(removeBookingRoomDto);
        if(bookingToRemove.isPresent()){
            roomCrudService.removeBooking(bookingToRemove.get());
            return bookingToRemove.get();
        }else {
            throw new ValidationException("Brak rezerwacji o takim identyfikatorze");
        }
    }

    private Optional<Booking> getBookingToRemove(RemoveBookingRoomDto removeBookingRoomDto){
        BookingFilter bookingFilter = new BookingFilter();
        bookingFilter.bookingId =removeBookingRoomDto.bookingId;
        bookingFilter.roomId = removeBookingRoomDto.roomId;
        return getBookingByFilterService.get(bookingFilter);
    }
}
