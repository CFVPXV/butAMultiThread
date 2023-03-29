package MyThreadedLife;

public class MyFirstThread implements Runnable{

    public String msg;
    public int count;

    public MyFirstThread(String m, int c){
        msg = m;
        count = c;
    }

    //Here we see a task which is what will be done upon
    @Override
    public void run() {

        for(int i = 0; i < count; i++){
            for(int j = 0; i < msg.length(); j++){
                System.out.println(msg.charAt(j));
            }
            System.out.println("");
        }

    }
}
