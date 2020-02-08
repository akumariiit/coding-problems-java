package com.dogacoder.www.abstractexample;

public class ConcreteClass extends AbstractOne {
    @Override
    public void print(String s) {
        System.out.println("Print in ConcreteClass " + s);
    }

    public void print1(String s) {
        System.out.println("Print in ConcreteClass " + s);
    }
}
