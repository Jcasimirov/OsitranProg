package com.ositran.util;

import java.lang.reflect.Field;

public class Entity {
    public Entity() {
    }
    
    public static <T> T updateChanges(T oDb, T oUp) {
        try {
            java.lang.reflect.Field[] fields = oDb.getClass().getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                if (field.get(oUp) != null && !java.lang.reflect.Modifier.isStatic(field.getModifiers())) {
                    field.set(oDb, field.get(oUp));
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return oDb;
    }
}
