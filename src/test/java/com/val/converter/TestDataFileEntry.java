package com.val.converter;


/*
*Обертка для троки файла тестовых данных
*/
public class TestDataFileEntry {

    public long argumentValue;
    public String expectedValue;

    public TestDataFileEntry(String line) {
        String[] a = line.split("\\s?=\\s?");
        argumentValue = Long.parseLong(a[0]);
        expectedValue = a[1];
    }
}
