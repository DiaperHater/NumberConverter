package com.val.converter;

import org.junit.Test;

import static org.junit.Assert.*;

public class ThreeDigitNumberConverterTest {

    private final ThreeDigitNumberConverter formatter = new ThreeDigitNumberConverter();

    @Test(expected = IllegalArgumentException.class)
    public void illegalArgument_throwsException(){
        formatter.asWords(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void illegalArgument_throwsException_2(){
        formatter.asWords(1000);
    }

    @Test
    public void argumentIsOk_noExceptionThrown(){
        formatter.asWords(898);
    }

    @Test
    public void argumentIsOk_returnsNumberInWordRepresentation(){
        assertEquals("сто", formatter.asWords(100));
    }

    @Test
    public void argumentIsOk_returnsNumberInWordRepresentation_2(){
        assertEquals("сто двадцать девять", formatter.asWords(129));
    }

    @Test
    public void argumentIsOk_returnsNumberInWordRepresentation_3(){
        assertEquals("ноль", formatter.asWords(0));
    }

    @Test
    public void argumentIsOk_returnsNumberInWordRepresentation_4(){
        assertEquals("двести семьдесят один", formatter.asWords(271));
    }
}