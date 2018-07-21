package com.val.converter;

import java.math.BigInteger;


/*
* Данный класс используется для преобразования старшей
* степени тысячи числа в его словесное представление
*/
class HighestExponentOfThousandConverter {

    private ThreeDigitNumberConverter threeDigitNumberConverter = new ThreeDigitNumberConverter();
    private NameListDao namesOfNumbersDao = new NamesOfNumbersDao();
    private final BigInteger ONE_THOUSAND = new BigInteger("1000");
    private BigInteger number;


    //Перегруженый asWords(BigInteger n)
    public String asWords(long n) {
        return asWords(new BigInteger(String.valueOf(n)));
    }

    //Метод преобразующий входной параметр num
    //в его словесное представление
    public String asWords(BigInteger n){

        number = n;

        checkArgument(n);

        if (numberIsLessThenOneThousand()){
            return threeDigitNumberConverter.asWords(number.intValue());
        }

        int exponent = -1;
        BigInteger poweredThousand;

        do {

            ++exponent;
            poweredThousand = ONE_THOUSAND.pow(exponent);

        }while ((number.divide(poweredThousand).compareTo(BigInteger.ZERO) > 0));

        poweredThousand = ONE_THOUSAND.pow(--exponent);

        String prefix = threeDigitNumberConverter.asWords(number.divide(poweredThousand).intValue());
        String suffix = namesOfNumbersDao.getName(exponent);


        if (poweredThousand.equals(ONE_THOUSAND)){
            return formatThousand(prefix, suffix);
        }

        return formatMillionsAndBigger(prefix, suffix);
    }

    //Метод для улучшения читаемости структуры if
    private boolean numberIsLessThenOneThousand() {
        return number.compareTo(BigInteger.valueOf(1000)) < 0;
    }

    //Метод формирующий правильные окончания для миллионов и больших чисел
    private String formatMillionsAndBigger(String prefix, String suffix) {
        if (prefix.toCharArray()[prefix.length()-1] == 'н'){
            return prefix +" "+ suffix;
        }
        if (prefix.toCharArray()[prefix.length()-1] == 'а'){
            if (prefix.equals("триста") || prefix.equals("четыреста")){
                return prefix +" "+ replaceLastCharacters(suffix, 0, "ов");
            }
            return prefix +" "+ replaceLastCharacters(suffix, 0, "а");
        }
        if (prefix.toCharArray()[prefix.length()-1] == 'и'){
            if (prefix.equals("двести")){
                return prefix +" "+ replaceLastCharacters(suffix, 0, "ов");
            }
            return prefix +" "+ replaceLastCharacters(suffix, 0, "а");
        }
        if (prefix.toCharArray()[prefix.length()-1] == 'е'){
            return prefix +" "+ replaceLastCharacters(suffix, 0, "а");
        }
        if (prefix.toCharArray()[prefix.length()-1] == 'ь'){
            return prefix +" "+ replaceLastCharacters(suffix, 0, "ов");
        }
        if (prefix.toCharArray()[prefix.length()-1] == 'т'){
            return prefix +" "+ replaceLastCharacters(suffix, 0, "ов");
        }
        if (prefix.toCharArray()[prefix.length()-1] == 'о'){
            return prefix +" "+ replaceLastCharacters(suffix, 0, "ов");
        }
        if (prefix.toCharArray()[prefix.length()-1] == 'к'){
            return prefix +" "+ replaceLastCharacters(suffix, 0, "ов");
        }

        throw new RuntimeException();
    }

    //Метод формирующий правильные окончания для тысяч
    private String formatThousand(String prefix, String suffix) {
        if (prefix.toCharArray()[prefix.length()-1] == 'ь'){
            return prefix +" "+ replaceLastCharacters(suffix, 1, "");
        }
        if (prefix.toCharArray()[prefix.length()-1] == 'а'){
            if (prefix.equals("триста") || prefix.equals("четыреста")){
                return prefix +" "+ replaceLastCharacters(suffix, 1, "");
            }
            return replaceLastCharacters(prefix, 1, "е") +
                    " " + replaceLastCharacters(suffix, 1, "и");
        }
        if (prefix.toCharArray()[prefix.length()-1] == 'и'){
            if (prefix.equals("двести")){
                return prefix +" "+ replaceLastCharacters(suffix, 1, "");
            }
            return prefix +" "+ replaceLastCharacters(suffix, 1, "и");
        }
        if (prefix.toCharArray()[prefix.length()-1] == 'е'){
            return prefix +" "+ replaceLastCharacters(suffix, 1, "и");
        }
        if (prefix.toCharArray()[prefix.length()-1] == 'н'){
            return replaceLastCharacters(prefix, 2, "на") +
                    " " + suffix;
        }
        if (prefix.toCharArray()[prefix.length()-1] == 'т'){
            return prefix +" "+ replaceLastCharacters(suffix, 1, "");
        }
        if (prefix.toCharArray()[prefix.length()-1] == 'о'){
            return prefix +" "+ replaceLastCharacters(suffix, 1, "");
        }
        if (prefix.toCharArray()[prefix.length()-1] == 'к'){
            return prefix +" "+ replaceLastCharacters(suffix, 1, "");
        }

        throw new RuntimeException();
    }

    //Проверка аргумента
    private void checkArgument(BigInteger arg) {
        if (arg.compareTo(BigInteger.ZERO) < 0){
            throw new IllegalArgumentException("arg = " + arg + " cant be negative!");
        }
    }

    //Утилита для замены концовки строки
    private String replaceLastCharacters(String targetString, int countOfCharsToReplace, String replacement){
        return targetString.substring(0, targetString.length() - countOfCharsToReplace)+replacement;
    }

}
