package com.val.converter;


import org.junit.Assert;
import org.junit.Test;

public class NumberConverterDDT {

    private static final NumberConverter converter = new NumberConverter();


    @Test
    public void test(){

        TestDataFileDao testDataFileDao = new TestDataFileDao();
        TestDataFileEntry pair;

        while (testDataFileDao.hasNext()){
            pair = testDataFileDao.next();
            Assert.assertEquals(pair.expectedValue, converter.asWords(pair.argumentValue));
        }

    }
}
