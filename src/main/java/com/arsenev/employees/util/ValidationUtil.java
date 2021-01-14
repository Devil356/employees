package com.arsenev.employees.util;

/**
 * Утильный метод. Описание - над методами.
 */
public class ValidationUtil {

    /**
     * Служит для раскручивания стектрейса до самого низа с целью выяснить
     * первопричину ошибки.
     * @param e - ошибка
     * @return - первопричина ошибки
     */
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
