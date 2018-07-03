package pl.whiteit.booking.light.room.cache;

import com.google.common.collect.Lists;
import com.google.gson.reflect.TypeToken;
import pl.whiteit.booking.light.booking.model.Booking;
import pl.whiteit.booking.light.common.annotation.Identificator;
import pl.whiteit.booking.light.common.annotation.Resources;
import pl.whiteit.booking.light.common.cache.DataCache;
import pl.whiteit.booking.light.common.cache.IdFactory;
import pl.whiteit.booking.light.common.data.DataResources;
import pl.whiteit.booking.light.common.data.IdType;
import pl.whiteit.booking.light.room.model.Room;

import javax.ejb.Startup;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Objects;

@Startup
@ApplicationScoped
@Resources(DataResources.ROOM)
public class RoomCache extends DataCache<Room> {

    @Inject
    @Identificator(IdType.ROOM)
    private IdFactory idRoomFactory;

    @Inject
    @Identificator(IdType.BOOKING)
    private IdFactory idBookingFactory;


    @Override
    protected Type getTypeTokenToJsonParse() {
        return new TypeToken<ArrayList<Room>>() {
        }.getType();
    }

    @Override
    protected IdFactory getIdFactory() {
        return idRoomFactory;
    }


    public void addBooking(Booking booking) {
        Room room = get(booking.room.id);
        if (Objects.isNull(room.bookingList)) {
            room.bookingList = Lists.newArrayList();
        }
        booking.id = idBookingFactory.getNextId();
        room.bookingList.add(booking);
    }


    public void removeBooking(Booking bookingToRemove){
        Room room = get(bookingToRemove.room.id);
        room.bookingList.removeIf(booking -> booking.id.equals(bookingToRemove.id));
    }
}
