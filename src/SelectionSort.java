/** P3: Selection Sort. Use m.less(...) for comparisons and m.swap(...) for swaps. */
public class SelectionSort implements Sorter {

    public String name() {
        return "Selection Sort";
    }

    public boolean isQuadratic() {
        return true;
    }

    public void sort(int[] arr, Metrics m) {

        // Move through the array one position at a time
        for (int i = 0; i < arr.length - 1; i++) {

            // Assume the current position contains the smallest value
            int minIndex = i;

            // Search the remaining unsorted part of the array
            for (int j = i + 1; j < arr.length; j++) {

                // Compare arr[j] with the current smallest value
                if (m.less(arr[j], arr[minIndex])) {
                    minIndex = j;
                }
            }

            // Put the smallest value into position i
            if (minIndex != i) {
                m.swap(arr, i, minIndex);
            }
        }
    }
}