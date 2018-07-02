package pl.whiteit.booking.light.common.rest;

import pl.whiteit.booking.light.common.model.BaseModel;

import java.util.List;

public class ResponseEntity<T extends BaseModel> extends Response {

    public T data;

}
