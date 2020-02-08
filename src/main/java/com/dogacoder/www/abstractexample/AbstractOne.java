package com.dogacoder.www.abstractexample;

public abstract class AbstractOne implements ParentInterface {
    public abstract void print(String s);

    public void printInAbstract(String s) {
        System.out.println("In AbstractOne " + s);
    }

}
