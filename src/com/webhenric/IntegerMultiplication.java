package com.webhenric;

public class IntegerMultiplication {

    public static void main(String[] args) {
        StandardAlgorithm standardAlgorithm = new StandardAlgorithm();
        String result = standardAlgorithm.compute(args[0].toCharArray(), args[1].toCharArray());

        System.out.println("The product is: " + result);
    }
}
