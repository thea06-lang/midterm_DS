import java.util.Arrays;
import java.util.Random;

/**
 * BubbleSortDemo.java
 *
 * NOT part of the final submission — this is just so I (P2) can check
 * my own Bubble Sort + Metrics work before P4's dataset generator and
 * P5's main test runner are ready to plug into. Once P4 pushes the
 * shared generator (same seed for every sort), swap the calls to
 * generateArray() below for theirs so every sort in the team is tested
 * on the exact same data.
 *
 * Sizes match the assignment: 5, 1,000, and 1,000,000 elements.
 * WARNING: at 1,000,000 elements Bubble Sort is roughly a trillion
 * operations and can take a very long time (see the plan's warning
 * about the 1,000,000-element run). Kick that size off early and let
 * it run in the background rather than waiting on it interactively —
 * or lower N below to sanity-check the code first.
 *
 * Author: P2
 */
public class BubbleSortDemo {

    public static void main(String[] args) {
        int[] sizes = {5, 1_000, 1_000_000};

        for (int size : sizes) {
            int[] data = generateArray(size, 42L); // fixed seed = repeatable results
            int[] copy = Arrays.copyOf(data, data.length); // never sort the original

            Metrics metrics = new Metrics();
            BubbleSort.sort(copy, metrics);

            System.out.println("n = " + size);
            System.out.println("  " + metrics);
            System.out.println("  sorted correctly: " + isSorted(copy));

            if (size <= 10) {
                System.out.println("  result: " + Arrays.toString(copy));
            }
            System.out.println();
        }
    }

    /** Simple random-array generator so I can test independently of P4's version. */
    private static int[] generateArray(int size, long seed) {
        Random random = new Random(seed);
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(1_000_000);
        }
        return arr;
    }

    /** Quick sanity check that the array really did end up sorted. */
    private static boolean isSorted(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] > arr[i]) {
                return false;
            }
        }
        return true;
    }
}
