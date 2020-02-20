package General;

import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * 
 * Instances can be used to parse lunch json data
 */
public class JsonLunchParser {
    private final Gson JsonParser;
    
    JsonLunchParser(){
        JsonParser = new Gson();
    }
    
    /**
     * 
     * @param JsonString the json string to be parsed
     * @return collection of the received data
     */
    public ArrayList<Lunch> parseJson(String JsonString){
        Lunch[] lunchArray = JsonParser.fromJson(JsonString, Lunch[].class);
        return new ArrayList<>(Arrays.asList(lunchArray));
    }
}
