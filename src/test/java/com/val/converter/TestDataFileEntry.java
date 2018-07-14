package com.val.converter;


/*
*Обертка для троки файла тестовых данных
*/
public class TestDataFileEntry {

    public String argumentValue;
    public String expectedValue;

    public TestDataFileEntry(String line) {
        String[] a = line.split("\\s?=\\s?");
        argumentValue = a[0];
        expectedValue = a[1];
    }
}
