package pl.whiteit.booking.light.common.action;

import org.apache.http.HttpStatus;
import pl.whiteit.booking.light.common.rest.Response;

public abstract class BaseAction<R extends Response> {

    protected R response;

    protected abstract void createResponse();

    protected void setSuccesResponse(){
        response.status = HttpStatus.SC_OK;
    }

    protected void setErrorResponse(){
        response.status = HttpStatus.SC_INTERNAL_SERVER_ERROR;
        response.message = "Błąd serwera";
    }
}
