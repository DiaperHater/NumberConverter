package com.val.converter;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/*
* Итератор для файла с тестовыми данными
* */

public class TestDataFileDao {

    private static final String filePath = "./test/com.val.converter.ddt/testData.lst";
    private static Scanner scanner;

    static {
        try {
            scanner = new Scanner(new FileReader(filePath));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public TestDataFileEntry next(){
        String line = scanner.nextLine();
        return new TestDataFileEntry(line);
    }

    public boolean hasNext(){
        return scanner.hasNext();
    }
    
}
