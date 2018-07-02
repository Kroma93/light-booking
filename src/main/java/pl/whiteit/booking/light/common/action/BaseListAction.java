package pl.whiteit.booking.light.common.action;

import pl.whiteit.booking.light.common.model.BaseModel;
import pl.whiteit.booking.light.common.rest.ResponseList;

import java.util.List;

public abstract class BaseListAction<T extends BaseModel> extends BaseAction<ResponseList<T>>  {


    public ResponseList<T> execute() {
        createResponse();
        try {
            List<T> data = executeAction();
            setDataToResponse(data);
        } catch (Exception e) {
            e.printStackTrace();
            setErrorResponse();
        }
        return response;
    }

    protected abstract List<T> executeAction() throws Exception;

    protected void setDataToResponse(List<T> data){
        response.data = data;
    }


    protected void createResponse() {
        response = new ResponseList<>();
        setSuccesResponse();

    }


}
