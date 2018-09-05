package org.ftd.educational.utils.json.results;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Fabio Tavares Dippold
 * @version 1.0.1 - 2018-06-20
 *
 */
public class SimpleResult implements Serializable {

    private boolean success = true;
    private int count = 0;
    private List<Object> data;
    private List<Error> errors;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<Object> getData() {
        return data;
    }

    public void setData(List<Object> data) {
        this.data = data;
        if (data != null) {
            setCount(data.size());
        }
    }

    public List<Error> getErrors() {
        return errors;
    }

    public void setErrors(List<Error> errors) {
        this.errors = errors;
    }

}
