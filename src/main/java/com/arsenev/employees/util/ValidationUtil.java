package com.arsenev.employees.util;

public class ValidationUtil {

    //  http://stackoverflow.com/a/28565320/548473
    public static Throwable getRootCause(Throwable e) {
        Throwable cause = null;
        Throwable result = e;

        while (null != (cause = result.getCause()) && (result != cause)) {
            result = cause;
        }
        return result;
    }
}
