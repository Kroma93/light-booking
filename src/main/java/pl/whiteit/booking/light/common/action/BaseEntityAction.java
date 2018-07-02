package pl.whiteit.booking.light.common.action;

import pl.whiteit.booking.light.common.model.BaseModel;
import pl.whiteit.booking.light.common.rest.ResponseEntity;

public abstract class BaseEntityAction<T extends BaseModel> extends BaseAction<ResponseEntity<T>> {

    public ResponseEntity<T> execute() {
        try {
            T data = executeAction();
            setDataToResponse(data);
        } catch (Exception e) {
            e.printStackTrace();
            setErrorResponse();
        }
        return response;
    }

    protected abstract T executeAction() throws Exception;

    protected void setDataToResponse(T data){
        response.data = data;
    }


    protected void createResponse() {
        response = new ResponseEntity<>();
        setSuccesResponse();
    }

}
