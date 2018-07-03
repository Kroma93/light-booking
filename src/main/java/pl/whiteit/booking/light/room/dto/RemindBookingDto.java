package pl.whiteit.booking.light.room.dto;

import pl.whiteit.booking.light.common.util.DateUtil;

import java.util.Date;

public class RemindBookingDto {

    public String room;
    public Date dateFrom;
    public Date dateTo;


    public String getFormattedDateFrom(){
        return DateUtil.formatDateToBase(dateFrom);
    }

    public String getFormattedDateTo(){
        return DateUtil.formatDateToBase(dateTo);
    }


}
