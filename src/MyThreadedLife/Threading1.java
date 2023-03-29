package MyThreadedLife;

public class Threading1 {

    public static void main(String[] args) {

        //Create tasks
        MyFirstThread x = new MyFirstThread("Hello there friend", 500);
        MyFirstThread y = new MyFirstThread("Ech, great", 200);

        //Create thread
        Thread t1 = new Thread(x);
        Thread t2 = new Thread(y);

        //BATTLE TO THE DEATH, of threads
        t1.start();
        t2.start();
    }
}
