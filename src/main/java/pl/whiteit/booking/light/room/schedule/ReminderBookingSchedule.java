package pl.whiteit.booking.light.room.schedule;

import pl.whiteit.booking.light.common.mail.Mail;
import pl.whiteit.booking.light.common.mail.MailService;
import pl.whiteit.booking.light.room.service.GetRemindBookingMailToSendService;

import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.inject.Inject;
import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;
import java.util.List;

@Singleton
public class ReminderBookingSchedule {

    @Inject
    private GetRemindBookingMailToSendService getMailToSendService;

    @Inject
    private MailService mailService;

    public ReminderBookingSchedule(){
        System.out.println("START SCHEDULE [ReminderBookingSchedule]");
    }

    @Schedule(minute = "*" , hour = "*")
    public void remind(){
        System.out.println("EXECUTE SCHEDULE [ReminderBookingSchedule]");

        List<Mail> mailsToSend = getMailToSendService.get();
        mailsToSend.forEach(mail -> {
            try {
                mailService.sendMail(mail);
                mail.booking.isSendReminder = true;
            } catch (MessagingException e) {
                e.printStackTrace();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        });
    }


}
