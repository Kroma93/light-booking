package pl.whiteit.booking.light.common.json;

import com.google.common.reflect.TypeToken;
import com.google.gson.GsonBuilder;
import pl.whiteit.booking.light.room.basic.model.Room;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class JsonDataFactory {

    public <T> List<T> getJsonDataFromFileResources(String filePath, Type type) throws Exception {
        InputStream inputStream = getClass().getClassLoader()
                .getResourceAsStream(filePath);
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));

        return new GsonBuilder().create().fromJson(br,type);
    }
}
