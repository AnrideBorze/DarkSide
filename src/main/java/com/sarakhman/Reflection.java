package com.sarakhman;
//Reflection:
//        Метод принимает класс и возвращает созданный объект этого класса
//        Метод принимает object и вызывает у него все методы без параметров
//        Метод принимает object и выводит на экран все сигнатуры методов в который есть final
//Метод принимает Class и выводит все не публичные методы этого класса
//        Метод принимает Class и выводит всех предков класса и все интерфейсы которое класс имплементирует
//        Метод принимает объект и меняет всего его приватные поля на их нулевые значение (null, 0, false etc)+

import java.lang.reflect.*;
import java.util.Arrays;

public class Reflection {
    Reflection(){
        System.out.println("Reflection!");
    }


    public Object createObjectClass(Class clazz){
        Object object = null;
        try {
            Class clazzOne = Class.forName(clazz.getName());
            object = (Object) clazzOne.newInstance();

        }
        catch (ClassNotFoundException | InstantiationException | IllegalAccessException e){
            e.printStackTrace();
        }
        return object;
    }

    public void callAllMethodsWithoutParameters(Object object) throws InvocationTargetException, IllegalAccessException {
    object = Object.class;
    Method[] allMethods = object.getClass().getDeclaredMethods();
        for (Method allMethod : allMethods) {
            if(Arrays.toString(allMethod.getParameterTypes()).equals("[]")) {
                allMethod.setAccessible(true);
                allMethod.invoke(object);
            }
        }
    }

    public void printSignaturesAllFinalMethods(Object object){
        Method[] finalMethod = object.getClass().getDeclaredMethods();
        for (Method method : finalMethod) {
            if(Modifier.isFinal(method.getModifiers())){
                System.out.println(method);
            }
        }

    }

    public void printAllNotPublicMethods(Class clazz){
    Object object = createObjectClass(clazz);
        Method[] finalMethod = object.getClass().getDeclaredMethods();
        for (Method method : finalMethod) {
            if(!Modifier.isPublic(method.getModifiers())){
                System.out.println(method);
            }
        }
    }

    public void printAllInterfacesAndParents(Class clazz){
    Class[] allClasses = clazz.getClasses();
    Class[] allInterfaces = clazz.getInterfaces();
        for (Class allClass : allClasses) {
            System.out.println(allClass);
        }
        for (Class allInterface : allInterfaces) {
            System.out.println(allInterface);
        }
    }
    public void changesAllPrivateFieldsOnTheirNullMeanings(Object object){
        Field[] allFields = object.getClass().getDeclaredFields();
        for (Field allField : allFields) {
            allField.setAccessible(true);
            object = allField.getClass().getSimpleName();
            Object objectName = allField.getClass().getName();
            if(object.equals("boolean")){
                objectName = false;
            }
            else if(object.equals("int")){
                objectName = 0;
            }
            else if(object.equals("double")){
                objectName = 0.0;
            }
            else if(object.equals("float")){
                objectName = 0.0;
            }
            else if(object.equals("byte")){
                objectName = 0;
            }
            else if(object.equals("short")){
                objectName = 0;
            }
            else if(object.equals("long")){
                objectName = 0;
            }
            else {
                objectName = null;
            }

        }
    }


}
