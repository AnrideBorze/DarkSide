package com.sarakhman;
//Reflection:
//        Метод принимает класс и возвращает созданный объект этого класса
//        Метод принимает object и вызывает у него все методы без параметров
//        Метод принимает object и выводит на экран все сигнатуры методов в который есть final
//Метод принимает Class и выводит все не публичные методы этого класса
//        Метод принимает Class и выводит всех предков класса и все интерфейсы которое класс имплементирует
//        Метод принимает объект и меняет всего его приватные поля на их нулевые значение (null, 0, false etc)+
public class Reflection {
    Reflection(){
        System.out.println("Reflection!");
    }


    public Object createObjectClass(Class clazz){
        Object object = null;
//        try {
//            Class clazzOne = Class.forName(clazz.getName());
//            object = (Object) clazzOne.newInstance();
//
//        }
//        catch (ClassNotFoundException | InstantiationException | IllegalAccessException e){
//            e.printStackTrace();
//        }
        return object;
    }

    public void callAllMethodsWithoutParameters(Object object){

    }

    public void printSignaturesAllFinalMethods(Object object){

    }

    public void printAllNotPublicMethods(Class clazz){

    }

    public void printAllInterfacesAndParents(Class clazz){

    }
    public void changesAllPrivateFieldsOnTheirNullMeanings(Object object){

    }
}
