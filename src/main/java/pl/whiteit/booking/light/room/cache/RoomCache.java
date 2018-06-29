package pl.whiteit.booking.light.room.cache;

import com.google.gson.reflect.TypeToken;
import pl.whiteit.booking.light.common.annotation.Resources;
import pl.whiteit.booking.light.common.cache.DataCache;
import pl.whiteit.booking.light.common.cache.IdFactory;
import pl.whiteit.booking.light.common.data.DataResources;
import pl.whiteit.booking.light.room.basic.model.Room;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.lang.reflect.Type;
import java.util.ArrayList;

@ApplicationScoped
@Resources(DataResources.ROOM)
public class RoomCache extends DataCache<Room> {

    @Inject
    @Resources(DataResources.ROOM)
    private IdFactory idFactory;


    @Override
    protected Type getTypeTokenToJsonParse() {
        return new TypeToken<ArrayList<Room>>(){}.getType();
    }

    @Override
    protected IdFactory getIdFactory() {
        return idFactory;
    }


}
