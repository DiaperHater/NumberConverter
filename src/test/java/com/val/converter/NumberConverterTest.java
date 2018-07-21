package com.val.converter;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class NumberConverterTest {

    private static final NumberConverter instance = new NumberConverter();

    @Test(expected = NumberFormatException.class)
    public void testAsWordsNotANumberThenException(){
        instance.asWords("123dfr");
    }

    @Test
    public void testAsWordsStringType(){
        String arg = "2002";
        assertEquals("две тысячи два", instance.asWords(arg));
    }

    @Test
    public void testAsWordsLongType(){
        Long arg = 2002L;
        assertEquals("две тысячи два", instance.asWords(arg));
    }

    @Test
    public void testAsWordsNegative(){
        Long arg = -33L;
        assertEquals("минус тридцать три", instance.asWords(arg));
    }

    @Test
    public void testAsWordsDataDriven(){

        TestDataFileDao testDataFileDao = new TestDataFileDao();
        TestDataFileEntry pair;

        while (testDataFileDao.hasNext()){
            pair = testDataFileDao.next();
            Assert.assertEquals(pair.expectedValue, instance.asWords(pair.argumentValue));
        }

    }
}