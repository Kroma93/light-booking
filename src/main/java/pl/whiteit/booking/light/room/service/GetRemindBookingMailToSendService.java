package pl.whiteit.booking.light.room.service;

import com.google.common.collect.Lists;
import org.apache.commons.lang3.time.DateUtils;
import pl.whiteit.booking.light.booking.model.Booking;
import pl.whiteit.booking.light.common.mail.Mail;
import pl.whiteit.booking.light.common.mail.MailContent;
import pl.whiteit.booking.light.common.util.DateUtil;
import pl.whiteit.booking.light.room.dto.RemindBookingDto;
import pl.whiteit.booking.light.room.mail.ReminderBookingMailContentBuilder;
import pl.whiteit.booking.light.room.model.Room;

import javax.inject.Inject;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class GetRemindBookingMailToSendService {

    @Inject
    private RoomCrudService roomCrudService;

    public List<Mail> get(){
        List<Mail> allMailToSend = Lists.newArrayList();
        roomCrudService.getAll().forEach(room -> {
            if(Objects.nonNull(room.bookingList)) {
                List<Booking> bookingToSendRemind = room.bookingList.stream().filter(booking -> isToSendRemind(booking)).collect(Collectors.toList());
                if(Objects.nonNull(bookingToSendRemind)){
                    List<Mail> mailtoSend = bookingToSendRemind.stream().map(booking -> prepareMail(room, booking)).collect(Collectors.toList());
                    allMailToSend.addAll(mailtoSend);
                }
            }
        });
        return allMailToSend;
    }

    private boolean isToSendRemind(Booking booking) {
        return !booking.isSendReminder && (DateUtils.isSameDay(DateUtil.getYesterday(),booking.dateFrom) || DateUtils.isSameDay(booking.dateFrom, new Date()));
    }

    private Mail prepareMail(Room room, Booking booking) {
        Mail mail = new Mail();
        mail.addressMail = booking.email;
        mail.content = prepareContentMail(room, booking);
        mail.subject = MailContent.BOOKING_REMINDER.subject;
        mail.booking = booking;
        return mail;
    }

    private String prepareContentMail(Room room, Booking booking) {
        RemindBookingDto remindBookingDto = new RemindBookingDto();
        remindBookingDto.dateFrom = booking.dateFrom;
        remindBookingDto.dateTo = booking.dateTo;
        remindBookingDto.room = room.name;
        return ReminderBookingMailContentBuilder.create().remindBookingDto(remindBookingDto).build();
    }
}
