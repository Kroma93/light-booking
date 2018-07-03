package pl.whiteit.booking.light.common.mail;

public enum MailContent {

    BOOKING_REMINDER("Przypominamy o rezerwacji pokoju %s w naszym hotelu. Rezerwacja rozpoczyna się %s a kończy %s. Życzymy miłego wypoczynku.","Przypomnienie o rezerwacji");

    public String content;
    public String subject;

    MailContent(String content, String subject){
        this.content = content;
        this.subject = subject;
    }
}
