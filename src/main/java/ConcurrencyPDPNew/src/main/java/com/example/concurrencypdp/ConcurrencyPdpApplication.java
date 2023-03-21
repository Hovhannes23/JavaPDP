package ConcurrencyPDPNew.src.main.java.com.example.concurrencypdp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.atomic.AtomicInteger;

@SpringBootApplication
public class ConcurrencyPdpApplication {
    static int i;
    static AtomicInteger atomicInteger = new AtomicInteger(0);

    // разница в работе integer и AtomicInteger
    public static void main(String[] args) {
        SpringApplication.run(ConcurrencyPdpApplication.class, args);

        for (int j = 0; j< 100_000; j ++) {
            new MyThread().start();
        }
        System.out.println(i);
        System.out.println(atomicInteger);
    }

    static class MyThread extends Thread {
        @Override
        public void run() {
            i++;
            atomicInteger.incrementAndGet();
        }
    }
}
