package pl.whiteit.booking.light.room.mail;

import com.sun.javafx.binding.StringFormatter;
import pl.whiteit.booking.light.common.mail.MailContent;
import pl.whiteit.booking.light.room.dto.RemindBookingDto;

public class ReminderBookingMailContentBuilder {

    private RemindBookingDto remindBookingDto;

    private ReminderBookingMailContentBuilder(){

    }

    public static ReminderBookingMailContentBuilder create(){
        return new ReminderBookingMailContentBuilder();
    }

    public ReminderBookingMailContentBuilder remindBookingDto(RemindBookingDto remindBookingDto){
        this.remindBookingDto = remindBookingDto;
        return this;
    }

    public String build(){
        return String.format(MailContent.BOOKING_REMINDER.content,remindBookingDto.room,remindBookingDto.getFormattedDateFrom(),remindBookingDto.getFormattedDateTo());
    }

}
