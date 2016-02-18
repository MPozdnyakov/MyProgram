import com.sun.org.apache.xpath.internal.SourceTree;

/**
 * Created by Mike on 2/17/2016.
 */
public class SyncTest {

    public static void main(String[] args) throws InterruptedException {


        Thread thread = new Thread(new Counter(0));
        Thread thread2 = new Thread(new Counter(1));
        Thread thread3 = new Thread(new Counter(2));

        thread.start();
        thread2.start();
        thread3.start();

        thread.join();
        thread2.join();
        thread3.join();
    }

}

class Counter implements Runnable {


     volatile private int adding;
    volatile private int switcher = 0;

    public Counter(int adding) {
        this.adding = adding;
    }


    @Override
    public void run() {
        for (int i = 1 + adding; i < 20; i += 3) {
            if (adding == 0) {

                while (switcher != 0) {}

                System.out.println(Thread.currentThread().getName() + " " + i);

                switcher = 1;
            }

            if (adding == 1) {

                while (switcher != 1) {}

                System.out.println(Thread.currentThread().getName() + " " + i);

                switcher = 2;
            }

            if (adding == 2) {

                while (switcher != 2) {}

                System.out.println(Thread.currentThread().getName() + " " + i);

                switcher = 0;
            }
        }
    }
}
