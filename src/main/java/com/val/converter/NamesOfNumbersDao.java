package com.val.converter;

import java.util.Scanner;

/*
* Обеспечивает доступ к файлу с именами степеней тысячи
* */
class NamesOfNumbersDao implements NameListDao {

    private static final String FILE_PATH = "/namesOfNumbers.lst";
    private static final int numberOfLinesInFile = 33;

    //Возвращает строку из файла с названием
    //степени тысячи указаной в аргументе exponent
    public String getName(int exponent) {
        if (exponent < 1){
            throw new IllegalArgumentException(" exponent arg CAN NOT BE NEGATIVE!");
        }
        if (exponent > numberOfLinesInFile){
            throw new IllegalArgumentException("exponent = " +exponent+ "arg IS TO BIG! File does not contain so many lines!");
        }

        Scanner scanner = new Scanner(getClass().getResourceAsStream(FILE_PATH));

        String result = null;
        for (int i = 1; i <= exponent ; i++) {
            result = scanner.nextLine()
                    .replace("\n", "")
                    .replace("\r", "");
        }


        return result;

    }

}
