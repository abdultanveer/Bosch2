package com.example.bosch;

import junit.framework.TestCase;

public class CalculatorTest extends TestCase {

    public void testAdd() {
        int expected = 40;
        int actual = Calculator.add(10,20);
        assertEquals(expected,actual);
    }

    public void testMultiply(){
        Calculator calculator = new Calculator();
        int expected = 20;
        int actual = calculator.multiply(5,4);
        assertEquals(expected,actual);
    }
}