package pl.whiteit.booking.light.common.rest;

import pl.whiteit.booking.light.common.model.BaseModel;

import java.util.List;

public class ResponseList<T extends BaseModel> extends Response {

    public List<T> data;
}
