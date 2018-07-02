package pl.whiteit.booking.light.room.model;

import pl.whiteit.booking.light.booking.model.Booking;
import pl.whiteit.booking.light.common.model.BaseModel;

import java.util.List;

public class Room extends BaseModel {

    public String name;
    public String description;
    public List<Booking> bookingList;

}
