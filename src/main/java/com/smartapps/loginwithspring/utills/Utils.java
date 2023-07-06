package com.smartapps.loginwithspring.utills;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class Utils {

    public static boolean isAnyFieldEmpty(Object model) throws IllegalAccessException {
        Field[] fields = model.getClass().getDeclaredFields();

        for (Field field : fields) {
            field.setAccessible(true);
            Object value = field.get(model);
            Annotation annotation = field.getAnnotation(AllowEmpty.class);
            if (annotation instanceof AllowEmpty allowEmpty) {
                if (!allowEmpty.value() && (value == null || (value instanceof String && ((String) value).isEmpty()))) {
                    return true; // Field cannot be empty but is empty
                }
            } else {
                if (value == null || (value instanceof String && ((String) value).isEmpty())) {
                    return true;
                }
            }
        }
        return false;
    }
}
