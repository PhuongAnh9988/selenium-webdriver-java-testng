package javaTester;

import java.util.Random;

public class Topic_06_Random {
    // Java Builtin ( Cung cap san - lay ra su dung)
    // Java Libraries ( Do 1 ca nhan/ to chuc ho tu viet)

    public static <Stirng> void main(Stirng[] args) {
        Random rand = new Random();
        System.out.println(rand.nextInt());
        System.out.println(rand.nextDouble());
        System.out.println("automation" + rand.nextInt(999999) + "gmail.net");
    }
}

