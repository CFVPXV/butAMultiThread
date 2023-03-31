package MyThreadedLife;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Threading1 {

    public static void main(String[] args) {

        //Create tasks
        MyFirstThread x = new MyFirstThread("Hello there, friend", 500);
        MyFirstThread y = new MyFirstThread("Ech, great", 200);

        //Create thread
        Thread t1 = new Thread(x);
        Thread t2 = new Thread(y);

        t1.start();
        t2.start();
        //BATTLE TO THE DEATH, of threads
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {

            //This executes first, interestingly.
            System.out.println("OF printings?");
        }

        tpools();
    }

    public static void tpools(){
        ExecutorService ex = Executors.newFixedThreadPool(3);
        ex.execute(new MyFirstThread("12345",500));
        ex.execute(new MyFirstThread("asdf",500));
        ex.execute(new MyFirstThread("!@#$%^&*",500));
        ex.shutdown();
    }
}
