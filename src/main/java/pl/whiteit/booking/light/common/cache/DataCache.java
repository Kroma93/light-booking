package pl.whiteit.booking.light.common.cache;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import pl.whiteit.booking.light.common.annotation.Resources;
import pl.whiteit.booking.light.common.data.DataResources;
import pl.whiteit.booking.light.common.json.JsonDataFactory;
import pl.whiteit.booking.light.common.model.BaseModel;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.io.FileNotFoundException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public abstract class DataCache<T extends BaseModel> {

    @Inject
    private JsonDataFactory jsonDataFactory;

    protected Cache<Long, T> cache;

    private List<T> dataFromResources;

    protected abstract IdFactory getIdFactory();

    protected abstract Type getTypeTokenToJsonParse();


    @PostConstruct
    public void create() {
        System.out.println("INIT CACHE " + getCacheName());

        initializeCache();
        try {
            loadDataFromResources();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("END CACHE " + getCacheName());
    }

    private void initializeCache() {
        cache = CacheBuilder.newBuilder().build(new CacheLoader<Long, T>() {
            @Override
            public T load(Long key) throws NullPointerException {
                Optional<T> dataPossible = dataFromResources.stream().filter(room -> room.id.equals(key)).findFirst();

                return dataPossible.orElseThrow(() -> new NullPointerException("Not found by this ID ---> " + key + " IN CACHE " + getCacheName()));
            }
        });
    }


    private void loadDataFromResources() throws Exception {
        try {
            dataFromResources = getAllDataFromResources();
            adds(dataFromResources);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private List<T> getAllDataFromResources() throws Exception {
        Type type = getTypeTokenToJsonParse();
        return jsonDataFactory.getJsonDataFromFileResources(getDataResources().getFilePath(), type);
    }


    protected DataResources getDataResources() {
        Resources annotation = getClass().getAnnotation(Resources.class);
        return annotation.value();
    }


    public void adds(List<T> newObjects) {
        newObjects.forEach(newObject -> add(newObject));

    }

    public void add(T newObject) {
        if (Objects.isNull(newObject.id)) {
            newObject.id = getIdFactory().getNextId();
        }
        cache.put(newObject.id, newObject);
    }


    public List<T> getAll() {
        return new ArrayList<>(cache.asMap().values());
    }

    public T get(Long key){
       return cache.getIfPresent(key);
    }

    protected String getCacheName() {
        Resources annotation = getClass().getAnnotation(Resources.class);
        return annotation.value().name();
    }

}
