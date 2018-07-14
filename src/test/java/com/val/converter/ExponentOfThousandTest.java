package com.val.converter;

import org.junit.Test;

import java.math.BigInteger;

import static org.junit.Assert.assertEquals;

public class ExponentOfThousandTest {

    private  final ExponentOfThousand exponentOfThousand = new ExponentOfThousand();




    @Test(expected = IllegalArgumentException.class)
    public void asWords_argumentIsNegative_throwsException(){
        BigInteger negativeNumber = BigInteger.valueOf(-2);
        exponentOfThousand.asWords(negativeNumber);
    }

    @Test
    public void asWords_argumentIsOk_noException(){
        BigInteger validNumber = BigInteger.valueOf(2);
        exponentOfThousand.asWords(validNumber);
    }




    @Test
    public void asWords_numberUnderOneThousand_returnsNumberInWordRepresentation_1(){
        BigInteger number = BigInteger.valueOf(1);

        String expected = "один";
        String actual = exponentOfThousand.asWords(number);

        assertEquals(expected, actual);
    }

    @Test
    public void asWords_numberUnderOneThousand_returnsNumberInWordRepresentation_2(){
        BigInteger number = BigInteger.valueOf(12);

        String expected = "двенадцать";
        String actual = exponentOfThousand.asWords(number);

        assertEquals(expected, actual);
    }

    @Test
    public void asWords_numberUnderOneThousand_returnsNumberInWordRepresentation_3(){
        BigInteger number = BigInteger.valueOf(95);

        String expected = "девяносто пять";
        String actual = exponentOfThousand.asWords(number);

        assertEquals(expected, actual);
    }




    @Test
    public void asWords_numberBetweenOneThousandAndOneMillion_returnsNumberInWordsWithCorrectEndings_1(){
        BigInteger number = BigInteger.valueOf(1000);

        String expected = "одна тысяча";
        String actual = exponentOfThousand.asWords(number);

        assertEquals(expected, actual);
    }

    @Test
    public void asWords_numberBetweenOneThousandAndOneMillion_returnsNumberInWordsWithCorrectEndings_2(){
        BigInteger number = BigInteger.valueOf(2000);

        String expected = "две тысячи";
        String actual = exponentOfThousand.asWords(number);

        assertEquals(expected, actual);
    }

    @Test
    public void asWords_numberBetweenOneThousandAndOneMillion_returnsNumberInWordsWithCorrectEndings_3(){
        BigInteger number = BigInteger.valueOf(3000);

        String expected = "три тысячи";
        String actual = exponentOfThousand.asWords(number);

        assertEquals(expected, actual);
    }

    @Test
    public void asWords_numberBetweenOneThousandAndOneMillion_returnsNumberInWordsWithCorrectEndings_4(){
        BigInteger number = BigInteger.valueOf(4000);

        String expected = "четыре тысячи";
        String actual = exponentOfThousand.asWords(number);

        assertEquals(expected, actual);
    }

    @Test
    public void asWords_numberBetweenOneThousandAndOneMillion_returnsNumberInWordsWithCorrectEndings_5(){
        BigInteger number = BigInteger.valueOf(5000);

        String expected = "пять тысяч";
        String actual = exponentOfThousand.asWords(number);

        assertEquals(expected, actual);
    }

    @Test
    public void asWords_numberBetweenOneThousandAndOneMillion_returnsNumberInWordsWithCorrectEndings_6(){
        BigInteger number = BigInteger.valueOf(7000);

        String expected = "семь тысяч";
        String actual = exponentOfThousand.asWords(number);

        assertEquals(expected, actual);
    }

    @Test
    public void asWords_numberBetweenOneThousandAndOneMillion_returnsNumberInWordsWithCorrectEndings_7(){
        BigInteger number = BigInteger.valueOf(40_000);

        String expected = "сорок тысяч";
        String actual = exponentOfThousand.asWords(number);

        assertEquals(expected, actual);
    }

    @Test
    public void asWords_numberBetweenOneThousandAndOneMillion_returnsNumberInWordsWithCorrectEndings_8(){
        BigInteger number = BigInteger.valueOf(90_000);

        String expected = "девяносто тысяч";
        String actual = exponentOfThousand.asWords(number);

        assertEquals(expected, actual);
    }

    @Test
    public void asWords_numberBetweenOneThousandAndOneMillion_returnsNumberInWordsWithCorrectEndings_9(){
        BigInteger number = BigInteger.valueOf(167_000);

        String expected = "сто шестьдесят семь тысяч";
        String actual = exponentOfThousand.asWords(number);

        assertEquals(expected, actual);
    }




    @Test
    public void asWords_numberBetweenMillionAndBillion_returnsNumberInWordsWithCorrectEndings_1(){
        BigInteger number = BigInteger.valueOf(1_000_000);

        String expected = "один миллион";
        String actual = exponentOfThousand.asWords(number);

        assertEquals(expected, actual);
    }

    @Test
    public void asWords_numberBetweenMillionAndBillion_returnsNumberInWordsWithCorrectEndings_2(){
        BigInteger number = BigInteger.valueOf(2_000_000);

        String expected = "два миллиона";
        String actual = exponentOfThousand.asWords(number);

        assertEquals(expected, actual);
    }

    @Test
    public void asWords_numberBetweenMillionAndBillion_returnsNumberInWordsWithCorrectEndings_3(){
        BigInteger number = BigInteger.valueOf(3_000_000);

        String expected = "три миллиона";
        String actual = exponentOfThousand.asWords(number);

        assertEquals(expected, actual);
    }

    @Test
    public void asWords_numberBetweenMillionAndBillion_returnsNumberInWordsWithCorrectEndings_4(){
        BigInteger number = BigInteger.valueOf(4_000_000);

        String expected = "четыре миллиона";
        String actual = exponentOfThousand.asWords(number);

        assertEquals(expected, actual);
    }

    @Test
    public void asWords_numberBetweenMillionAndBillion_returnsNumberInWordsWithCorrectEndings_5(){
        BigInteger number = BigInteger.valueOf(5_000_000);

        String expected = "пять миллионов";
        String actual = exponentOfThousand.asWords(number);

        assertEquals(expected, actual);
    }

    @Test
    public void asWords_numberBetweenMillionAndBillion_returnsNumberInWordsWithCorrectEndings_6(){
        BigInteger number = BigInteger.valueOf(40_000_000);

        String expected = "сорок миллионов";
        String actual = exponentOfThousand.asWords(number);

        assertEquals(expected, actual);
    }

    @Test
    public void asWords_numberBetweenMillionAndBillion_returnsNumberInWordsWithCorrectEndings_7(){
        BigInteger number = BigInteger.valueOf(50_000_000);

        String expected = "пятьдесят миллионов";
        String actual = exponentOfThousand.asWords(number);

        assertEquals(expected, actual);
    }

    @Test
    public void asWords_numberBetweenMillionAndBillion_returnsNumberInWordsWithCorrectEndings_8(){
        BigInteger number = BigInteger.valueOf(90_000_000);

        String expected = "девяносто миллионов";
        String actual = exponentOfThousand.asWords(number);

        assertEquals(expected, actual);
    }





    @Test
    public void asWords_bigRandomNumber_returnsNumberInWordRepresentation_1(){
        BigInteger number = new BigInteger("400000000000");

        String expected = "четыреста миллиардов";
        String actual = exponentOfThousand.asWords(number);

        assertEquals(expected, actual);
    }

    @Test
    public void asWords_bigRandomNumber_returnsNumberInWordRepresentation_2(){
        BigInteger number = new BigInteger("91000000000000000000");

        String expected = "девяносто один квинтиллион";
        String actual = exponentOfThousand.asWords(number);

        assertEquals(expected, actual);
    }


}