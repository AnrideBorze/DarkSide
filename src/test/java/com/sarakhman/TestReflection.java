package com.sarakhman;

//Reflection:
//        Метод принимает класс и возвращает созданный объект этого класса
//        Метод принимает object и вызывает у него все методы без параметров
//        Метод принимает object и выводит на экран все сигнатуры методов в который есть final
//Метод принимает Class и выводит все не публичные методы этого класса
//        Метод принимает Class и выводит всех предков класса и все интерфейсы которое класс имплементирует
//        Метод принимает объект и меняет всего его приватные поля на их нулевые значение (null, 0, false etc)+


import org.junit.Test;

public class TestReflection {




    @Test
    public void testCreateObjectClassWorkCorrectly(){
        Reflection reflection = new Reflection();
    }

    @Test
    public void testCallAllMethodsWithoutParametersWorkCorrectly(){
        Reflection reflection = new Reflection();
    }

    @Test
    public void testPrintSignaturesAllFinalMethodsWorkCorrectly(){
        Reflection reflection = new Reflection();
    }

    @Test
    public void testPrintAllNotPublicMethodsWorkCorrectly(){
        Reflection reflection = new Reflection();
    }

    @Test
    public void testPrintAllInterfacesAndParentsWorkCorrectly(){
        Reflection reflection = new Reflection();
    }

    @Test
    public void testChangesAllPrivateFieldsOnTheirNullMeaningsWorkCorrectly(){
        Reflection reflection = new Reflection();
    }
}
