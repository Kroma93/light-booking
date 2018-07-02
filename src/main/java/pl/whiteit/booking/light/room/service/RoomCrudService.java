package pl.whiteit.booking.light.room.service;

import pl.whiteit.booking.light.booking.model.Booking;
import pl.whiteit.booking.light.common.annotation.Resources;
import pl.whiteit.booking.light.common.data.DataResources;
import pl.whiteit.booking.light.room.cache.RoomCache;
import pl.whiteit.booking.light.room.model.Room;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class RoomCrudService {

    @Inject
    @Resources(DataResources.ROOM)
    private RoomCache roomCache;

    public List<Room> getAll(){
        return roomCache.getAll();
    }

    public void addBooking(Booking booking){
        roomCache.addBooking(booking);
    }

    public Room getRoomById(Long id){
        return roomCache.get(id);
    }

    public void removeBooking(Booking booking){
        roomCache.removeBooking(booking);
    }


}
