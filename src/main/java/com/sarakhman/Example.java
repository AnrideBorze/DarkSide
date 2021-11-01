package com.sarakhman;

public class Example {
    public int i = 1;
    private int b = 2;
    private final int C = 3;
    String name = "name";
    private String surname = "Surname";
    private final String USERNAME = "username";

    Example(){

    }

    public void setI(int i) {
        this.i = i;
    }

    public void setB(int b) {
        this.b = b;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
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

    public final void makeIBigger(){
i++;
    }
    private  void printHello(){
        System.out.println("Hello");
    }
}
