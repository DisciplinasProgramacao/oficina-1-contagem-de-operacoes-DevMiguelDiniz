package sorts;

import java.util.Arrays;
import utils.Utils;

public class Bubblesort<T extends Comparable<T>> implements ISorter<T>{
    private int comparisons = 0;
    private int swaps;
    private int time;
    private Utils<T> utils = new Utils<T>();

    @Override
    public T[] sort(T[] data) {
        T[] arrayCopy = Arrays.copyOf(data, data.length);
        int n = arrayCopy.length;
        // Now the methot sorts the array
        startTime();
        for (int i = 1; i < n; i++ ){
            for (int j = 0; j < n - 1; j++){
                comparisons++;
                if (arrayCopy[j].compareTo(arrayCopy[j+1]) > 0) {
                    swaps++;
                    utils.swap(arrayCopy, j, j+1);
                }
            }
        }
        endTime();
        return arrayCopy;
    }

    @Override
    public int getComparisons() {
        return 0;
    }

    @Override
    public int getSwaps() {
        return 0;
    }

    @Override
    public int getTime() {
        return 0;
    }
    private void startTime(){
        // Inicializes the counter
    }
    private void endTime(){
        // Ends the counter
    }
}
