package com.sarakhman;
//Reflection:
//        Метод принимает класс и возвращает созданный объект этого класса
//        Метод принимает object и вызывает у него все методы без параметров
//        Метод принимает object и выводит на экран все сигнатуры методов в который есть final
//Метод принимает Class и выводит все не публичные методы этого класса
//        Метод принимает Class и выводит всех предков класса и все интерфейсы которое класс имплементирует
//        Метод принимает объект и меняет всего его приватные поля на их нулевые значение (null, 0, false etc)+

import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Reflection {
    public static void main(String[] args) {




    }





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
            if(Arrays.toString(allMethod.getParameterTypes()).equals("")) {
                allMethod.setAccessible(true);
                allMethod.invoke(object);
            }
        }
    }

    public void printSignaturesAllFinalMethods(Object object){
        List<String> forPrint = getAllSignaturesFinalMethods(object);

        for (String s : forPrint) {
            System.out.println(s);
        }

    }

    public void printAllNotPublicMethods(Class clazz){
        List<String> forPrint = getAllNotPublicMethods(clazz);
        for (String s : forPrint) {
            System.out.println(s);
        }
    }

    public void printAllInterfacesAndParents(Class clazz){
        List<String> forPrint = getAllInterfacesAndParents(clazz);
        for (String s : forPrint) {
            System.out.println(s);
        }

    }
    public void changesAllPrivateFieldsOnTheirNullMeanings(Object object) throws IllegalAccessException {
        Field[] allFields = object.getClass().getDeclaredFields();
        for (Field allField : allFields) {
           if(Modifier.isPrivate(allField.getModifiers())){
                allField.setAccessible(true);
                Object objectType = allField.getType();
                if(objectType==boolean.class){
                    allField.set(object,(Object)false);
                }
                else if(objectType==int.class||objectType==byte.class||objectType==short.class||objectType==long.class){
                    allField.set(object,(Object)0);
                }
                else if(objectType==double.class||objectType==float.class){
                    allField.set(object,(Object)0.0);
                }
                else {
                    allField.set(object,(Object)null);
                }

            }
        }
    }

    public List<String> getAllNotPublicMethods(Class clazz){
        List<String> result = new ArrayList();

        Object object = createObjectClass(clazz);
        Method[] finalMethod = object.getClass().getDeclaredMethods();
        for (Method method : finalMethod) {
            if(!Modifier.isPublic(method.getModifiers())){
                result.add(method.toString());
            }
        }


        return result;
    }
    public List<String> getAllSignaturesFinalMethods(Object object){
        List<String> result = new ArrayList();
        Method[] finalMethod = object.getClass().getDeclaredMethods();
        for (Method method : finalMethod) {
            if(Modifier.isFinal(method.getModifiers())){
                result.add(method.toString())   ;
            }
        }
        return result;
    }

    public List<String> getAllInterfacesAndParents(Class clazz) {
        List<String> result = new ArrayList();

        Class[] allClasses = clazz.getClasses();
        Class[] allInterfaces = clazz.getInterfaces();

        for (Class allClass : allClasses) {
            result.add(allClass.toString());
        }
        for (Class allInterface : allInterfaces) {
            result.add(allInterface.toString());
        }
        return result;
    }

}
