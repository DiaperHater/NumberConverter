package com.val.converter;

import org.junit.Test;

import static org.junit.Assert.*;

public class NumberConverterTest {

    private final NumberConverter formatter = new NumberConverter();

    @Test(expected = NumberFormatException.class)
    public void argIsNotNumber_throwsException(){
        formatter.asWords("123dfr");
    }

    @Test
    public void argIsOk_noException(){
        formatter.asWords("9876123456");
    }

    @Test
    public void argIsOk_returnsNumberInWordRepresentation(){
        assertEquals("ноль", formatter.asWords("0"));
    }

    @Test
    public void argIsOk_returnsNumberInWordRepresentation_2(){
        assertEquals("две тысячи два", formatter.asWords("2002"));
    }

    @Test
    public void argIsOk_returnsNumberInWordRepresentation_3(){
        assertEquals("минус три", formatter.asWords("-3"));
    }


}