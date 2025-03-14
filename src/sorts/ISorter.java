package sorts;

public interface ISorter<T extends Comparable<T>> {
    T[] sort(T[] data);
    int getComparisons();
    int getSwaps();
    int getTime();

}
