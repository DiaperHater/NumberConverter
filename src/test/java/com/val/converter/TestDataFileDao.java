package com.val.converter;

import java.util.Scanner;

/*
* Итератор для файла с тестовыми данными
* */

public class TestDataFileDao {

    private static final String FILE_PATH = "/testData.lst";
    private static Scanner scanner;

    public TestDataFileDao() {
        scanner = new Scanner(TestDataFileDao.class.getResourceAsStream(FILE_PATH));
    }

    public TestDataFileEntry next(){
        String line = scanner.nextLine();
        return new TestDataFileEntry(line);
    }

    public boolean hasNext(){
        return scanner.hasNext();
    }
    
}
