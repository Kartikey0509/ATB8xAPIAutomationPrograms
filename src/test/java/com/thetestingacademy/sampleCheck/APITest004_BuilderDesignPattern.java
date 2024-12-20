package com.thetestingacademy.sampleCheck;

public class APITest004_BuilderDesignPattern {
    // Change return type of each method as Class type
    // "this" always points to current/calling object. Returning the same to
    // have same reference

    public APITest004_BuilderDesignPattern step1(){
        System.out.println("Step 1 is started");
        System.out.println("Step 1 is done");
        return this;
    }

    public APITest004_BuilderDesignPattern step2(){
        System.out.println("Step 2 is started");
        System.out.println("Step 2 is done");
        return this;
    }

    public APITest004_BuilderDesignPattern step3(String name){
        System.out.println("Step 3 is started");
        System.out.println("Step 3 is done -->"+name);
        return this;
    }

    public static void main(String[] args) {
        APITest004_BuilderDesignPattern bd = new APITest004_BuilderDesignPattern();
        bd.step1().step2().step3("Kartik");
    }
}
