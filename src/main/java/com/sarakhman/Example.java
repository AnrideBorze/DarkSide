package com.sarakhman;

public class Example {
    public int i = 1;
    private int b = 2;
    private final int C = 3;
    String name = "name";
    private String surname = "Surname";
    private final String USERNAME = "username";

    Example(){
        System.out.println(i + b + C);
        System.out.println(name + surname + USERNAME);
    }

    public int getI() {
        return i;
    }

    public int getB() {
        return b;
    }

    public int getC() {
        return C;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getUSERNAME() {
        return USERNAME;
    }
}
