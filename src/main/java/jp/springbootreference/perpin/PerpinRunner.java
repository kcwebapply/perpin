package jp.springbootreference.perpin;


import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.stream.IntStream;

//@Component
public class PerpinRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {

        Perpin.setPin(1);
        IntStream.rangeClosed(0,100000).filter(i -> i % 3 ==0 ).sum();
        int i;
        int sum = 0;
        for (i=0; i < 100000; i++){
            if(i %3 == 0){
                sum += i;
            }
            Object test = new Object();
            Random random = new Random();
            int randomValue = random.nextInt(100);
            random.toString();
            test.toString();
        }
        Perpin.getPin(1);
        Thread.sleep(1000);

    }
}
