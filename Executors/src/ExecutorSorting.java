import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * Created by Mike on 2/22/2016.
 */
public class ExecutorSorting {


    public static void main(String[] args) {

        int[] array = new int[100];
        System.out.println("unsorted");
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 10) - 0;
            System.out.print(array[i] + ", ");
        }
        ForkJoinPool pool = new ForkJoinPool();
        RecursiveAction task = new RecursiveAction(array, 0, array.length);
        int[] sortedArray = pool.invoke(task);
        System.out.println();
        System.out.println("sorted");
        System.out.println();
        for (int i = 0; i < array.length; i++) {
            System.out.print(sortedArray[i]);
        }

    }
}

class RecursiveAction extends RecursiveTask<int[]> {
    private int array[];
    private int start;
    private int end;
    RecursiveAction(int[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;

    }
    int[] mergedArray = new int[100];

    @Override
    protected int[] compute() {
       ;
        if (end - start <= 25) {
            int sum = 0;
            for (int i = start; i < array.length; i++) {
                for (int j = 0; j < array.length - i - 1; j++) {
                    if (array[j] > array[j + 1]) {
                        int t = array[j];
                        array[j] = array[j + 1];
                        array[j + 1] = t;
                    }
                }
            }
            return array;
        } else {

            int middle = ((end - start) / 2) + start;
            RecursiveAction left = new RecursiveAction(array, start, middle);
            left.fork();
            RecursiveAction right = new RecursiveAction(array, middle, end);

            int[] array = right.compute();
            int[] array2 = left.join();
//
            return array;
        }

    }
}
