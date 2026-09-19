/**
 * Shared performance counters. EVERY sort must use this class so results are comparable.
 *
 * How to use inside a sort:
 *   m.greater(a, b) / m.less(a, b)  -> compares two values AND counts 1 comparison
 *   m.swap(arr, i, j)               -> swaps two elements AND counts 1 swap
 *   m.move()                        -> count 1 movement (Insertion Sort shifts, not swaps)
 *   m.countExtra()                  -> algorithm-specific metric (Heap Sort: heapify calls)
 */
public class Metrics {
    private long comparisons = 0;
    private long swaps = 0;
    private long moves = 0;
    private long extra = 0;
    private long startNanos = 0;
    private long elapsedNanos = 0;

    public boolean greater(int a, int b) {
        comparisons++;
        return a > b;
    }

    public boolean less(int a, int b) {
        comparisons++;
        return a < b;
    }

    public void swap(int[] arr, int i, int j) {
        swaps++;
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void move()       { moves++; }
    public void countExtra() { extra++; }

    public void startTimer() { startNanos = System.nanoTime(); }
    public void stopTimer()  { elapsedNanos = System.nanoTime() - startNanos; }

    public long getComparisons() { return comparisons; }
    public long getSwaps()       { return swaps; }
    public long getMoves()       { return moves; }
    public long getExtra()       { return extra; }
    public double getRuntimeMs() { return elapsedNanos / 1_000_000.0; }
}
