package com.solvd.CarService.utils;

import com.solvd.CarService.annotations.Sensitive;
import com.solvd.CarService.model.FieldResult;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;


public class SensitiveMasker {
    public static List<FieldResult> mask(Object object){

        ArrayList<FieldResult> results = new ArrayList<>();
        
        Class<?> currentClass = object.getClass();
        while (currentClass !=null){
            for (Field field : currentClass.getDeclaredFields()){
                try {
                    
                    field.setAccessible(true);
                    String name = field.getName();
                    Object value = field.get(object);

                    if(field.isAnnotationPresent(Sensitive.class)){
                        results.add(new FieldResult(name, "***"));
                        //System.out.println(name+":" + " ***");
                    }else{
                        results.add(new FieldResult(name, value));                        //System.out.println(name +": "+ value);
                    }
                }catch (IllegalAccessException e){
                    System.out.println(e.getMessage());
                }

            }
            currentClass = currentClass.getSuperclass();
        }
        return results;


    }
}
