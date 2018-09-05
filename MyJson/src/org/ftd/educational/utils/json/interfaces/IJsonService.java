package org.ftd.educational.utils.json.interfaces;

/**
 *
 * @author Fabio Tavares Dippold
 * @version 1.0.0 - 2018-06-20
 * 
 */
public interface IJsonService {
    
   String getJsonObject(Object oJava);
   Object getJavaObject(String oJson, Class javaClass);
   
}
