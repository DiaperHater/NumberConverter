package com.val.converter;

import java.util.LinkedHashMap;
import java.util.Map;

/*
* Данный класс используется для преобразовния
* любого целочислинного значения в диапазоне
* от 0 до 999 в его словесное представление.
*/
class ThreeDigitNumberConverter {
    private final Map<Integer , String> firstDigitToWordMap = new LinkedHashMap();
    private final Map<Integer , String> secondDigitToWordMap = new LinkedHashMap();
    private final Map<Integer , String> thirdDigitToWordMap = new LinkedHashMap();

    public ThreeDigitNumberConverter() {
        fillFirstDigitToWordMap();
        fillSecondDigitToWordMap();
        fillThirdDigitToWordMap();
    }

    //Метод преобразующий входной параметр num
    //в его словесное представление
    public String asWords(Integer num){

        if (num < 0 || num > 999){
            throw new IllegalArgumentException("argument = " + num);
        }


        String result = "";

        if(num > 99){
            result = thirdDigitToWordMap.get(num / 100) + " ";
        }
        result += formatFirstTwoDigits(num % 100);
        result = result.replaceAll(" ноль","");

        return result;
    }

    //Преобразует число от 0 до 9 в его словесное представление
    private String formatFirstDigit(Integer num) {

        if(num < 0 || num > 9){
            throw new IllegalArgumentException("argument = " + num.toString());
        }

        return firstDigitToWordMap.get(num);
    }

    //Преобразует  число от 0 до 99 в его словесное представление
    //использует formatFirstDigit() в качестве вспомогательной функции
    private String formatFirstTwoDigits(Integer num){

        if(num < 0 || num > 99){
            throw new IllegalArgumentException("argument = " + num);
        }

        if (num < 10){
            return formatFirstDigit(num);
        }

        if (num < 20){
            return secondDigitToWordMap.get(num);
        }

        int secondDigit = num / 10;
        String result = secondDigitToWordMap.get(secondDigit);
        int firstDigit = num % 10;

        if (firstDigit != 0){
            result += " " + firstDigitToWordMap.get(firstDigit);
        }

        return result;
    }

    //Утилиты инициализации полей класса
    private void fillFirstDigitToWordMap() {
        firstDigitToWordMap.put(0, "ноль");
        firstDigitToWordMap.put(1, "один");
        firstDigitToWordMap.put(2, "два");
        firstDigitToWordMap.put(3, "три");
        firstDigitToWordMap.put(4, "четыре");
        firstDigitToWordMap.put(5, "пять");
        firstDigitToWordMap.put(6, "шесть");
        firstDigitToWordMap.put(7, "семь");
        firstDigitToWordMap.put(8, "восемь");
        firstDigitToWordMap.put(9, "девять");
    }
    private void fillSecondDigitToWordMap() {

        secondDigitToWordMap.put(10, "десять");
        secondDigitToWordMap.put(11, "одинадцать");
        secondDigitToWordMap.put(12, "двенадцать");
        secondDigitToWordMap.put(13, "тринадцать");
        secondDigitToWordMap.put(14, "четырнадцать");
        secondDigitToWordMap.put(15, "пятнадцать");
        secondDigitToWordMap.put(16, "шестнадцать");
        secondDigitToWordMap.put(17, "семнадцать");
        secondDigitToWordMap.put(18, "восемнадцать");
        secondDigitToWordMap.put(19, "девятнадцать");
        secondDigitToWordMap.put(2,"двадцать");
        secondDigitToWordMap.put(3,"тридцать");
        secondDigitToWordMap.put(4,"сорок");
        secondDigitToWordMap.put(5,"пятьдесят");
        secondDigitToWordMap.put(6,"шестьдесят");
        secondDigitToWordMap.put(7,"семьдесят");
        secondDigitToWordMap.put(8,"восемьдесят");
        secondDigitToWordMap.put(9,"девяносто");
    }
    private void fillThirdDigitToWordMap() {
        thirdDigitToWordMap.put(1, "сто");
        thirdDigitToWordMap.put(2, "двести");
        thirdDigitToWordMap.put(3, "триста");
        thirdDigitToWordMap.put(4, "четыреста");
        thirdDigitToWordMap.put(5, "пятьсот");
        thirdDigitToWordMap.put(6, "шестьсот");
        thirdDigitToWordMap.put(7, "семьсот");
        thirdDigitToWordMap.put(8, "восемьсот");
        thirdDigitToWordMap.put(9, "девятьсот");
    }
}
