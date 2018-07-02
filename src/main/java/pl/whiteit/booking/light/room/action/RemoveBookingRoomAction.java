package pl.whiteit.booking.light.room.action;

import org.apache.http.HttpStatus;
import pl.whiteit.booking.light.booking.model.Booking;
import pl.whiteit.booking.light.common.action.ExecuteBaseAction;
import pl.whiteit.booking.light.common.exception.ValidationException;
import pl.whiteit.booking.light.room.dto.RemoveBookingRoomDto;
import pl.whiteit.booking.light.room.service.RemoveBookingService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@RequestScoped
public class RemoveBookingRoomAction extends ExecuteBaseAction<RemoveBookingRoomDto,Booking> {


    @Inject
    private RemoveBookingService removeBookingService;


    @Override
    protected Booking executeAction(RemoveBookingRoomDto objectToExecute) {
        try {
            return removeBookingService.removeBooking(objectToExecute);
        } catch (ValidationException e) {
            response.message = e.getMessage();
            response.status = HttpStatus.SC_INTERNAL_SERVER_ERROR;
        }
        return null;
    }
}
