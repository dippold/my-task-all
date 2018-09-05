package org.ftd.educational.utils.json.results;

import java.io.Serializable;

/**
 *
 * @author Fabio Tavares Dippold
 * @version 1.0.1 - 2018-06-20
 *
 */
public class Error implements Serializable {

    private String code;
    private String description;

    public Error(String code, String description) {
        setCode(code);
        setDescription(description);
    }
    
    public String getCode() {
        return code;
    }

    public final void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public final void setDescription(String description) {
        this.description = description;
    }

}
