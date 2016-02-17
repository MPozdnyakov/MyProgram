import com.sun.org.apache.xpath.internal.SourceTree;

/**
 * Created by Mike on 2/17/2016.
 */
public class SyncTest {

    public static void main(String[] args) {
        CustomMutex mutex = new CustomMutex();

        Thread thread = new Thread(new Counter(mutex));
        Thread thread2 = new Thread(new Counter(mutex));
        Thread thread3 = new Thread(new Counter(mutex));

        thread.start();
        thread2.start();
        thread3.start();

    }

}

class Counter implements Runnable {
    int counter = 0;
    CustomMutex mutex;

    public Counter(CustomMutex mutex) {
        this.mutex =mutex;
    }

    @Override
    public void run() {
        synchronized (mutex) {
//            try {
//                mutex.wait();
                for (int i = 0; i < 5; i++) {
                    System.out.println(Thread.currentThread().getName() + " " + numbersCounter());
                }
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }

    }
    }

    private int numbersCounter() {
        {
            counter++;
        }
        return counter;
    }
}

class CustomMutex{
    int i =0;
}