package pl.whiteit.booking.light.room.action;

import pl.whiteit.booking.light.common.action.BaseListAction;
import pl.whiteit.booking.light.room.model.Room;
import pl.whiteit.booking.light.room.service.RoomCrudService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.List;

@RequestScoped
public class GetAllRoomAction extends BaseListAction<Room> {


    @Inject
    private RoomCrudService roomCrudService;

    @Override
    protected List<Room> executeAction() {
        return roomCrudService.getAll();
    }


}
