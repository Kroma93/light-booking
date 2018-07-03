package pl.whiteit.booking.light.booking.model;

import pl.whiteit.booking.light.common.model.BaseModel;
import pl.whiteit.booking.light.room.model.Room;

import java.util.Date;

public class Booking extends BaseModel {

    public Date dateFrom;
    public Date dateTo;
    public Integer numberPeople;
    public String email;
    public Room room;

    public boolean isSendReminder;
}
