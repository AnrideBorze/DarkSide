package com.sarakhman;

//Reflection:
//        Метод принимает класс и возвращает созданный объект этого класса
//        Метод принимает object и вызывает у него все методы без параметров
//        Метод принимает object и выводит на экран все сигнатуры методов в который есть final
//Метод принимает Class и выводит все не публичные методы этого класса
//        Метод принимает Class и выводит всех предков класса и все интерфейсы которое класс имплементирует
//        Метод принимает объект и меняет всего его приватные поля на их нулевые значение (null, 0, false etc)+


import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;

import static junit.framework.Assert.assertFalse;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class TestReflection {




    @Test
    public void testCreateObjectClassCreateObject(){
        Reflection reflection = new Reflection();
        Object object = reflection.createObjectClass(Example.class);
        assertFalse(object.equals(null));
    }

    @Test
    public void testCallAllMethodsWithoutParametersWorkCorrectly() throws InvocationTargetException, IllegalAccessException {
        Reflection reflection = new Reflection();

        Object object = reflection.createObjectClass(Example.class);
        Example example = (Example) object;
        reflection.callAllMethodsWithoutParameters(object);
        assertEquals(2,example.getI());
    }

    @Test
    public void testPrintSignaturesAllFinalMethodsWorkCorrectly(){
        Reflection reflection = new Reflection();
        Object object = reflection.createObjectClass(Example.class);
        reflection.printSignaturesAllFinalMethods(object);

    }

    @Test
    public void testPrintAllNotPublicMethodsWorkCorrectly(){
        Reflection reflection = new Reflection();
        reflection.printAllNotPublicMethods(Example.class);
    }

    @Test
    public void testPrintAllInterfacesAndParentsWorkCorrectly(){
        Reflection reflection = new Reflection();
        reflection.printAllInterfacesAndParents(Example.class);
    }

    @Test
    public void testChangesAllPrivateFieldsOnTheirNullMeaningsWorkCorrectly(){
        Reflection reflection = new Reflection();
        reflection.changesAllPrivateFieldsOnTheirNullMeanings(reflection.createObjectClass(Example.class));
    }
}
