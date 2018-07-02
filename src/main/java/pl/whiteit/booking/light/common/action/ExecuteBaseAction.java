package pl.whiteit.booking.light.common.action;

import pl.whiteit.booking.light.common.model.BaseModel;
import pl.whiteit.booking.light.common.rest.ResponseEntity;

public abstract class ExecuteBaseAction<E,T extends BaseModel> extends BaseAction<ResponseEntity<T>> {


    public ResponseEntity<T> execute(E objectToExecute){
        createResponse();
        try {
            T data = executeAction(objectToExecute);
            setDataToResponse(data);
        } catch (Exception e) {
            e.printStackTrace();
            setErrorResponse();
        }
        return response;
    }


    protected void createResponse() {
        response = new ResponseEntity<>();
        setSuccesResponse();
    }

    protected abstract T executeAction(E objectToExecute) throws Exception;

    protected void setDataToResponse(T data){
        response.data = data;
    }
}
