package com.meiheyoupin.common.utils;

import java.util.*;

public class ConvertUtil {
    public ConvertUtil() {
    }

    public static void convertDataBaseMapToJavaMap(Object obj) {
        Iterator var3;
        if(obj instanceof Map) {
            Map array = (Map)obj;
            HashMap array1 = new HashMap();
            var3 = array.keySet().iterator();

            while(var3.hasNext()) {
                String ele = (String)var3.next();
                String newEle = convertKeyStringFromDBToJava(ele);
                array1.put(newEle, array.get(ele));
            }

            ((Map)obj).clear();
            ((Map)obj).putAll(array1);
        } else if(obj instanceof List) {
            List array1 = (List)obj;
            ArrayList array11 = new ArrayList();
            var3 = array1.iterator();

            while(var3.hasNext()) {
                Object ele1 = var3.next();
                HashMap newEle1 = new HashMap();
                Iterator var6 = ((Map)ele1).keySet().iterator();

                while(var6.hasNext()) {
                    String key = (String)var6.next();
                    String newKey = convertKeyStringFromDBToJava(key);
                    newEle1.put(newKey, ((Map)ele1).get(key));
                }

                array11.add(newEle1);
            }

            array1.removeAll(array1);
            array1.addAll(array11);
        }

    }

    public static String convertKeyStringFromDBToJava(String keyName) {
        String[] array = keyName.split("_");
        keyName = array[0];

        for(int i = 1; i < array.length; ++i) {
            String ele = array[i];
            ele = ele.substring(0, 1).toUpperCase() + ele.substring(1);
            keyName = keyName + ele;
        }

        return keyName;
    }

}