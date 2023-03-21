package ConcurrencyPDPNew.src.main.java.com.example.concurrencypdp;

import java.sql.SQLOutput;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableFuturesExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<Integer> callable = new MyCallable();
        FutureTask futureTask = new FutureTask(callable);
        Thread thread = new Thread(futureTask);
        thread.start();
        System.out.println(futureTask.get());
        System.out.println("After get()");
        CompletableFuture completableFuture;

    }

    static class MyCallable implements Callable<Integer> {
        @Override
        public Integer call() throws InterruptedException {
            int j = 0;
            for(int i = 0; i < 5; i++) {
                j+=i;
                Thread.sleep(200);
            }
            return j;
        }
    }
}


