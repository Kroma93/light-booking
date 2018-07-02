package pl.whiteit.booking.light.room.cache;

import pl.whiteit.booking.light.common.annotation.Identificator;
import pl.whiteit.booking.light.common.annotation.Resources;
import pl.whiteit.booking.light.common.cache.IdFactory;
import pl.whiteit.booking.light.common.data.DataResources;
import pl.whiteit.booking.light.common.data.IdType;

import javax.ejb.Singleton;
import java.util.concurrent.atomic.AtomicLong;

@Singleton
@Identificator(IdType.BOOKING)
public class BookingIdFactory implements IdFactory {

    AtomicLong atomicLong = new AtomicLong(0);

    @Override
    public Long getNextId() {
        return atomicLong.incrementAndGet();
    }
}
