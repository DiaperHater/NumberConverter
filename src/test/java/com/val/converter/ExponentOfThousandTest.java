package com.val.converter;

import org.junit.Test;

import java.math.BigInteger;

import static org.junit.Assert.assertEquals;

public class ExponentOfThousandTest {

    private  final ExponentOfThousand exponentOfThousand = new ExponentOfThousand();




    @Test(expected = IllegalArgumentException.class)
    public void testAsWordsThrowsExceptionIfNegative(){
        BigInteger negativeNumber = BigInteger.valueOf(-2);
        exponentOfThousand.asWords(negativeNumber);
    }

    @Test
    public void testAsWordsUnderOneThousand(){

        long args[] = {1, 12, 95};
        String expected[] = {"один", "двенадцать", "девяносто пять"};

        for (int i = 0; i < args.length; i++){
            assertEquals("argument value = "+args[i] ,expected[i] , exponentOfThousand.asWords(args[i]));
        }
    }


    @Test
    public void testAsWordsThousandsOnlyEndingsCheck(){
        long args[] = {1000, 2000, 3000, 4000, 5000, 7000, 40000, 90000, 167000};
        String expected[] = {"одна тысяча", "две тысячи", "три тысячи", "четыре тысячи", "пять тысяч", "семь тысяч",
                "сорок тысяч", "девяносто тысяч", "сто шестьдесят семь тысяч"};

        for (int i = 0; i < args.length; i++){
            assertEquals("argument value = "+args[i] ,expected[i] , exponentOfThousand.asWords(args[i]));
        }
    }



    @Test
    public void testAsWordsAboveThousandsEndingCheck(){
        long args[] = {1000000, 2000000, 5000000, 21355542532L, 22497580865797L, 90086547247364591L};
        String expected[] = {"один миллион", "два миллиона", "пять миллионов", "двадцать один миллиард"
                ,"двадцать два триллиона", "девяносто квадриллионов"};

        for (int i = 0; i < args.length; i++){
            assertEquals("argument value = "+args[i] ,expected[i] , exponentOfThousand.asWords(args[i]));
        }
    }

    @Test
    public void testAsWordsAnyPositiveReturnsOnlyHighestExponentOfThousandByWords(){
        long args[] = {1, 12, 95, 253452, 423564577, 84568356246L};
        String expected[] = {"один", "двенадцать", "девяносто пять", "двести пятьдесят три тысячи"
                , "четыреста двадцать три миллиона", "восемьдесят четыре миллиарда"};

        for (int i = 0; i < args.length; i++){
            assertEquals("argument value = "+args[i] ,expected[i] , exponentOfThousand.asWords(args[i]));
        }
    }

}