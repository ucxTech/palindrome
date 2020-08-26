package com.ucx.utility.palindrome.javaexcercise;

import com.ucx.utility.palindrome.javaexcercise.abstractpackage.Rectangle;
import com.ucx.utility.palindrome.javaexcercise.abstractpackage.Shape;
import com.ucx.utility.palindrome.javaexcercise.interfacepackage.BesnikCalculatorImpl;
import com.ucx.utility.palindrome.javaexcercise.interfacepackage.Calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        //programing on interface
        Calculator calculator = new BesnikCalculatorImpl();

        //not recommended
        BesnikCalculatorImpl calculator1 = new BesnikCalculatorImpl();

        System.out.println(calculator.add(1,2));


        //Rectangle is a Shape
        Shape shape = new Rectangle();

        //not recommended
        Rectangle rectangle = new Rectangle();


        //AUTOBOXING VS UNBOXING
        //primitive data types
        //byte, short, int, long, float, double, char, boolean
        //object types (Primitive wrappers)
        //Byte, Short, Integer, Long, Float, Double, Character, Boolean


        //autoboxing
        int a = 3;
        Integer b = a;

        //unboxing
        Integer a1 = 3;
        int b1 = a1;

        //explicit VS implicit conversion

        //implicit conversion
        Rectangle rectangle1 = new Rectangle();
        Shape shape1 = rectangle1;

        //explicit conversion
        Rectangle rectangle2 = (Rectangle) shape1;

        //Data Structures

        //mutable object
        List<Integer> list = new ArrayList();
        list.add(1);

        //arrays.asList() is immutable,  you can not mutate its state
        List list1 = Arrays.asList(1, 2, 3);
        //error list1.add(4);

        List list2 = List.of(1, 2, 3);
        //error list2.add(4);


        //String is immutable
        String str = "Hello";
        str = "Hello1";
        System.out.println(str); //prints Hello1


        //Recommended to use this for small values like -128 , 127
        Long l = Long.valueOf(3);

        //use the above sample than this for small values
        Long l1 = new Long(3);

    }

    public static Calculator getCalculator(){
        return new BesnikCalculatorImpl();
    }

    //not recommended
    public static BesnikCalculatorImpl getCalculator1(){
        return new BesnikCalculatorImpl();
    }
}
