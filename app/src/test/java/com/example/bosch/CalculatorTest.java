package com.example.bosch;

import junit.framework.TestCase;

public class CalculatorTest extends TestCase {
    Calculator calculator;
    @Override
    protected void setUp() throws Exception {
        super.setUp();
         calculator = new Calculator();

    }

    public void testAdd() {
        int expected = 40;
        int actual = Calculator.add(10,20);
        assertEquals(expected,actual);
    }

    public void testMultiply(){
        int expected = 20;
        int actual = calculator.multiply(5,4);
        assertEquals(expected,actual);
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
}