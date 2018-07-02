package pl.whiteit.booking.light.room.controller;


import pl.whiteit.booking.light.api.RoomApi;
import pl.whiteit.booking.light.booking.model.Booking;
import pl.whiteit.booking.light.common.rest.ResponseEntity;
import pl.whiteit.booking.light.common.rest.ResponseList;
import pl.whiteit.booking.light.room.action.AddBookingRoomAction;
import pl.whiteit.booking.light.room.action.GetAllRoomAction;
import pl.whiteit.booking.light.room.action.RemoveBookingRoomAction;
import pl.whiteit.booking.light.room.dto.AddBookingRoomDto;
import pl.whiteit.booking.light.room.dto.RemoveBookingRoomDto;
import pl.whiteit.booking.light.room.model.Room;

import javax.inject.Inject;

public class RoomController implements RoomApi {

    @Inject
    private GetAllRoomAction getAllRoomAction;

    @Inject
    private AddBookingRoomAction addBookingRoomAction;


    @Inject
    private RemoveBookingRoomAction removeBookingRoomAction;

    @Override
    public ResponseList<Room> getAll() {
        return getAllRoomAction.execute();
    }

    @Override
    public ResponseEntity<Booking> bookingRoom(AddBookingRoomDto addBookingRoomDto) {
        return addBookingRoomAction.execute(addBookingRoomDto);
    }

    @Override
    public ResponseEntity<Booking> removeBookingRoom(RemoveBookingRoomDto removeBookingRoomDto) {
        return removeBookingRoomAction.execute(removeBookingRoomDto);
    }
}
