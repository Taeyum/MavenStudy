package com.nhnacademy;
import com.nhnacademy.NullCheck.isNullCheck;
import com.nhnacademy.Random.UtilRandom;

public class App 
{
    public static void main( String[] args ) {
        UtilRandom rand = new UtilRandom();
        isNullCheck nullcheck = new isNullCheck();
        int a = rand.UtilRandom();
        int b = rand.Math3Random();
        Object o = null;
        String s = null;

        System.out.println("Random 난수 값 : "+a);
        System.out.println("Apache Commons Math 난수 값 : " + b);

        System.out.println("Objects.isNull 사용 : " + nullcheck.nullCheck1(o));
        System.out.println("Apache Commons Lang 사용 : " + nullcheck.nullCheck2(s));
    }


}
