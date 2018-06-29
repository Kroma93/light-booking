package pl.whiteit.booking.light.room.list.controller;


import pl.whiteit.booking.light.common.annotation.Resources;
import pl.whiteit.booking.light.common.data.DataResources;
import pl.whiteit.booking.light.room.basic.model.Room;
import pl.whiteit.booking.light.room.cache.RoomCache;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/room/list")
public class RoomController {

    @Inject
    @Resources(DataResources.ROOM)
    private RoomCache roomCache;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Room> getAllRooms(){
        return roomCache.getAll();
    }
}
