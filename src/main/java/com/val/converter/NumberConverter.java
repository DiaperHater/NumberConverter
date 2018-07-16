package com.val.converter;

import com.val.converter.ExponentOfThousand;

import java.math.BigInteger;
import java.util.ArrayList;


/*
* Класс преобразующий любое целое число в его словесное представление
* */

public class NumberConverter {

    private final ExponentOfThousand exponentOfThousand = new ExponentOfThousand();
    private final BigInteger ONE_THOUSAND = new BigInteger("1000");

    //Перегруженый asWords(BigInteger)
    public String asWords(long num) {
        return asWords(BigInteger.valueOf(num));
    }

    //Перегруженый asWords(BigInteger)
    public String asWords(String num) {
        return asWords(new BigInteger(num));
    }

    //Метод преобразующий входной параметр num
    //в его словесное представление
    public String asWords(BigInteger number){

        if (number.signum() == 0){
            return "ноль";
        }

        String sign = "";
        if (number.signum() == -1){
            sign = "минус";
            number = number.negate();
        }


        ArrayList<BigInteger> list = new ArrayList();
        int exponent = 0;
        BigInteger poweredThousand = ONE_THOUSAND.pow(exponent);
        StringBuilder sb = new StringBuilder();

        while (poweredThousand.compareTo(number) <= 0){

            BigInteger divisionResult = number.divide(poweredThousand);
            BigInteger remainderResult = divisionResult.remainder(ONE_THOUSAND);
            BigInteger nThExponentOfThousnd = remainderResult.multiply(poweredThousand);

            if( nThExponentOfThousnd.equals(BigInteger.ZERO) ){
                ++exponent;
                poweredThousand = ONE_THOUSAND.pow(exponent);
                continue;
            }
            sb.insert(0, " " + exponentOfThousand.asWords(nThExponentOfThousnd) );

            ++exponent;
            poweredThousand = ONE_THOUSAND.pow(exponent);
        }

        String result = sb.toString().substring(1);

        if (sign.length() != 0){
            result = sign +" "+ result;
        }

        return result;
    }


}
