package pl.whiteit.booking.light.common.data;

import com.google.common.base.Joiner;

import java.io.File;

public enum DataResources {

    ROOM("roomsData.json");

    private String fileName;

    private final String folder="/data";

    DataResources(String fileName){
        this.fileName = fileName;
    }

    public String getFilePath(){
       return Joiner.on(File.separator).join(folder,fileName);
    }
}
