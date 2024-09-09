package com.nhnacademy.Random;
import java.util.Random;
import org.apache.commons.math3.random.RandomDataGenerator;

public class UtilRandom {
    public int UtilRandom() {
        Random rand = new Random();
     return rand.nextInt(100);
    }
    public int Math3Random() {
        RandomDataGenerator rand = new RandomDataGenerator();
        return rand.nextInt(1,100);
    }
}
