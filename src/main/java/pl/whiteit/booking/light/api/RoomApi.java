package pl.whiteit.booking.light.api;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import pl.whiteit.booking.light.booking.model.Booking;
import pl.whiteit.booking.light.common.rest.ResponseEntity;
import pl.whiteit.booking.light.common.rest.ResponseList;
import pl.whiteit.booking.light.room.dto.AddBookingRoomDto;
import pl.whiteit.booking.light.room.dto.RemoveBookingRoomDto;
import pl.whiteit.booking.light.room.model.Room;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/room")

public interface RoomApi {


    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Get All Rooms and booking",
            tags = {"room"},
            description = "Returns a room with booking",
            responses = {
                    @ApiResponse(description = "The Rooms and Reservation", content = @Content(
                            schema = @Schema(implementation = Room.class)
                    ))
            })
    ResponseList<Room> getAll();


    @POST
    @Path("/booking/add")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "Booking",
            tags = {"booking"},
            description = "Booking room by date, email, roomid, numberPeople",
            responses = {
                    @ApiResponse(description = "The Booking", content = @Content(
                            schema = @Schema(implementation = AddBookingRoomDto.class)
                    ))
            })
    ResponseEntity<Booking> bookingRoom(AddBookingRoomDto addBookingRoomDto);

    @DELETE
    @Path("/booking/remove")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "Remove Booking",
            tags = {"booking"},
            description = "Booking remove by bookingId and roomId",
            responses = {
                    @ApiResponse(description = "The Remove Booking", content = @Content(
                            schema = @Schema(implementation = RemoveBookingRoomDto.class)
                    ))
            })
    ResponseEntity<Booking> removeBookingRoom(RemoveBookingRoomDto removeBookingRoomDto);
}
