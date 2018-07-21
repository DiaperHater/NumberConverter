package com.val.converter;

import org.junit.Test;

import static org.junit.Assert.*;

public class ThreeDigitNumberConverterTest {

    private final ThreeDigitNumberConverter instance = new ThreeDigitNumberConverter();

    @Test(expected = IllegalArgumentException.class)
    public void testAsWordsThrowsExceptionIfNegative(){
        instance.asWords(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAsWordsThrowsExceptionIfBiggerThen999(){
        instance.asWords(1000);
    }

    @Test
    public void testAsWordsInRange0to999(){
        int args[] = {0, 100, 129, 271};
        String expected[] = {"ноль","сто", "сто двадцать девять", "двести семьдесят один"};

        for (int i = 0; i < args.length; i++) {
            assertEquals("argument value = "+args[i] ,expected[i] , instance.asWords(args[i]));
        }
    }

}