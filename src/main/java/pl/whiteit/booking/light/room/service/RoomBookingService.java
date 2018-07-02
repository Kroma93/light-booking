package pl.whiteit.booking.light.room.service;

import pl.whiteit.booking.light.booking.model.Booking;
import pl.whiteit.booking.light.common.exception.ValidationException;
import pl.whiteit.booking.light.room.dto.AddBookingRoomDto;
import pl.whiteit.booking.light.room.model.Room;
import pl.whiteit.booking.light.room.validator.AddBookingValidator;

import javax.inject.Inject;


public class RoomBookingService {

    @Inject
    private RoomCrudService roomCrudService;

    @Inject
    private AddBookingValidator addBookingValidator;

    public Booking bookingRoom(AddBookingRoomDto addBookingRoomDto) throws ValidationException {
        Booking booking = parseToBooking(addBookingRoomDto);
        addBookingValidator.valid(booking);
        roomCrudService.addBooking(booking);
        return booking;
    }

    private Booking parseToBooking(AddBookingRoomDto addBookingRoomDto){
        Booking booking = new Booking();
        booking.dateTo=addBookingRoomDto.dateTo;
        booking.dateFrom=addBookingRoomDto.dateFrom;
        booking.email=addBookingRoomDto.email;
        booking.numberPeople=addBookingRoomDto.numberPeople;
        booking.room = new Room();
        booking.room.id = addBookingRoomDto.roomId;
        return booking;
    }
}
