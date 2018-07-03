package pl.whiteit.booking.light.room.action;

import org.apache.http.HttpStatus;
import pl.whiteit.booking.light.booking.model.Booking;
import pl.whiteit.booking.light.common.action.ExecuteBaseAction;
import pl.whiteit.booking.light.common.exception.ValidationException;
import pl.whiteit.booking.light.common.mail.MailService;
import pl.whiteit.booking.light.room.dto.AddBookingRoomDto;
import pl.whiteit.booking.light.room.service.RoomBookingService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@RequestScoped
public class AddBookingRoomAction extends ExecuteBaseAction<AddBookingRoomDto,Booking> {


    @Inject
    private RoomBookingService roomBookingService;




    @Override
    protected Booking executeAction(AddBookingRoomDto objectToExecute) {
        try {
            return roomBookingService.bookingRoom(objectToExecute);
        } catch (ValidationException e) {
            response.message = e.getMessage();
            response.status = HttpStatus.SC_INTERNAL_SERVER_ERROR;
        }
        return null;
    }
}
