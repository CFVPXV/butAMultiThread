package MyThreadedLife;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyFirstThread implements Runnable{

    public String msg;
    public int count;
    //The following in essence will allow for the threads to at least have a chance for complete execution, that
    //is, a full print
    public static Lock conLock = new ReentrantLock();

    public MyFirstThread(String m, int c){
        msg = m;
        count = c;
    }

    //Here we see a "task", might be an important piece of lingo which is what will be done upon
    @Override
    public void run() {

        for(int i = 0; i < count; i++) {
            //The resource being locked is the console
            /*Dining philosophers m8
            * Array of Locks
            * Array of Philosophers
            * Philosophers must share two indicies in arrays*/
            conLock.lock();
            for (int j = 0; j < msg.length(); j++) {

                System.out.print(msg.charAt(j));
            }
            System.out.println("");
            conLock.unlock();
            //After unlocking, we may have other logic to perform:
            //Sleep inside a for loop causes massive slow-downs for us as well
            try{
                //But it allows for even more fair distribution of thread processing
                Thread.sleep(10);
                //Yield also hints at a pause, but it's not guaranteed
                //Thread.yield();
            }catch (InterruptedException e){
                System.out.println(e.getMessage());
            }

        }

    }
}
