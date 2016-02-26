import java.sql.Time;
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
        RecursiveAction task = new RecursiveAction(array);
        double start = System.currentTimeMillis();
        int[] sortedArray = pool.invoke(task);
        System.out.println();
        System.out.println("sorted");
        System.out.println();
        for (int i = 0; i < array.length; i++) {
            System.out.print(sortedArray[i]+", ");
        }
        double stop = System.currentTimeMillis();
        System.out.println();
        System.out.println("time "+ (stop-start));

    }
}

class RecursiveAction extends RecursiveTask<int[]> {
    private int array[];

    RecursiveAction(int[] array) {
        this.array = array;

    }

    @Override
    protected int[] compute() {

        if (array.length <= 25) {
            for (int i = 0; i < array.length - 1; i++) {
                for (int j = i + 1; j < array.length; j++) {
                    if (array[i] > array[j]) {
                        int t = array[j];
                        array[j] = array[i];
                        array[i] = t;
                    }
                }
            }
            return array;
        } else {
            int middle = array.length / 2;
            RecursiveAction left = new RecursiveAction(Arrays.copyOfRange(array, 0, middle));
            left.fork();
            RecursiveAction right = new RecursiveAction(Arrays.copyOfRange(array, middle, array.length));

            int[] array1 = right.compute();
            int[] array2 = left.join();

            return mergeArrays(array1, array2);
        }
    }

    private int[] mergeArrays(int[] array1, int[] array2) {
        int[] mergedArray = new int[array1.length + array2.length];
        int a = 0, b = 0;
        for (int i = 0; i < mergedArray.length; i++) {
            if (a == array1.length) {
                mergedArray[i] = array2[b++];
                continue;
            }

            if (b == array2.length) {
                mergedArray[i] = array1[a++];
                continue;
            }

            if (array1[a] < array2[b]) {
                mergedArray[i] = array1[a++];
            } else {
                mergedArray[i] = array2[b++];
            }
        }
        return mergedArray;
    }


}
