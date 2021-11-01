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

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class TestReflection {




    @Test
    public void testCreateObjectClassCreateObject(){
        Reflection reflection = new Reflection();
        Object object = reflection.createObjectClass(Example.class);
        assertNotNull(object);
        assertEquals(Example.class,object.getClass());


    }

    @Test
    public void testCallAllMethodsWithoutParametersWorkCorrectly() throws InvocationTargetException, IllegalAccessException, NoSuchFieldException {
        Reflection reflection = new Reflection();

        Object object = reflection.createObjectClass(Example.class);
        reflection.callAllMethodsWithoutParameters(object);
        Field field = object.getClass().getField("i");
        field.setAccessible(true);
        assertEquals(1,field.get(object));
    }

    @Test
    public void testGetSignaturesAllFinalMethodsWorkCorrectly(){
        Reflection reflection = new Reflection();
        Object object = reflection.createObjectClass(Example.class);
        List<String> actual = reflection.getAllSignaturesFinalMethods(object);
        List<String> expected = new ArrayList<>();
        expected.add("public final void com.sarakhman.Example.makeIBigger()");
        assertEquals(expected,actual);

    }

    @Test
    public void testAllNotPublicMethodsWorkCorrectly(){
        Reflection reflection = new Reflection();
        List<String> actual = reflection.getAllNotPublicMethods(Example.class);
        List<String> expected = new ArrayList<>();
        expected.add("private void com.sarakhman.Example.printHello()");
        assertEquals(expected,actual);

    }

    @Test
    public void testAllInterfacesAndParentsWorkCorrectly(){
        Reflection reflection = new Reflection();
        List<String> actual = reflection.getAllInterfacesAndParents(Example.class);
        List<String> expected = new ArrayList<>();
        assertEquals(expected,actual);

    }

    @Test
    public void testChangesAllPrivateFieldsOnTheirNullMeaningsWorkCorrectly() throws IllegalAccessException {
        Reflection reflection = new Reflection();
        reflection.changesAllPrivateFieldsOnTheirNullMeanings(reflection.createObjectClass(Example.class));
        Object object = reflection.createObjectClass(Example.class);
        reflection.changesAllPrivateFieldsOnTheirNullMeanings(object);
        Field[] field = object.getClass().getDeclaredFields();
        for (Field field1 : field) {
            if (Modifier.isPrivate(field1.getModifiers())) {
                Object fieldName = field1.getType();
                field1.setAccessible(true);
                if (fieldName == boolean.class) {
                    assertEquals(false, field1.get(object));
                } else if (fieldName == int.class || fieldName == byte.class || fieldName == short.class || fieldName == long.class) {
                    assertEquals(0, field1.get(object));

                } else if (fieldName == double.class || fieldName == float.class) {
                    assertEquals(0.0, field1.get(object));

                } else {
                    assertEquals(null, field1.get(object));
                }
            }
        }
    }
}
