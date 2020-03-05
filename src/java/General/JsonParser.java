
/*package General;

import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * 
 * Generic Json parser class
 * @param <T> T is type of object parsed
 
public class JsonParser<T> {
    private final Gson parser;
    
    public JsonParser(){
        parser = new Gson();
    }
    
    /**
     * 
     * @param JsonString the json string to be parsed
     * @param storageClass specifies array class that stores temporary result
     * @return collection of the received data
     
    public ArrayList<T> parseJson(String JsonString, Class<T[]> storageClass){
        T[] contentsArray = parser.fromJson(JsonString, storageClass);
        return new ArrayList<>(Arrays.asList(contentsArray));
    }
}
*/
