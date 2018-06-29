package pl.whiteit.booking.light.room.cache;

import pl.whiteit.booking.light.common.annotation.Resources;
import pl.whiteit.booking.light.common.cache.IdFactory;
import pl.whiteit.booking.light.common.data.DataResources;

import javax.ejb.Singleton;
import java.util.concurrent.atomic.AtomicLong;

@Singleton
@Resources(DataResources.ROOM)
public class RoomIdFactory implements IdFactory {

    AtomicLong atomicLong = new AtomicLong(0);

    @Override
    public Long getNextId() {
        return atomicLong.incrementAndGet();
    }
}
