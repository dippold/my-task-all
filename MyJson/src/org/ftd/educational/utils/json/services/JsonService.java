package org.ftd.educational.utils.json.services;

import com.google.gson.Gson;
import org.ftd.educational.utils.json.interfaces.IJsonService;

/**
 *
 * @author Fabio Tavares Dippold
 * @version 1.0.0 - 2018-06-20
 *
 */
public class JsonService implements IJsonService {
    private static IJsonService INSTANCE;
    
    static {
        INSTANCE = new JsonService();
    }
    
    public static IJsonService getInstance() {
        return INSTANCE;
    }
    
    private JsonService() {        
    }
    
    @Override
    public String getJsonObject(Object oJava) {
        Gson gson = new Gson();

        return gson.toJson(oJava);
    }

    @Override
    public Object getJavaObject(String oJson, Class javaClass) {
        Gson gson = new Gson();

        return gson.fromJson(oJson, javaClass);
    }

    private boolean isNumeric(String str) {
        try {
            double d = Double.parseDouble(str);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

}
