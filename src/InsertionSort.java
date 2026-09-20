/** P3: Insertion Sort. Shifts are movements: call m.move() for each shift, not m.swap(). */
public class InsertionSort implements Sorter {

    public String name() {
        return "Insertion Sort";
    }

    public boolean isQuadratic() {
        return true;
    }

    public void sort(int[] arr, Metrics m) {

        // Start from index 1 because index 0 is already "sorted"
        for (int i = 1; i < arr.length; i++) {

            // Save the value we want to insert
            int key = arr[i];

            // Start checking from the element before key
            int j = i - 1;

            // Shift larger elements one position to the right
            while (j >= 0 && m.greater(arr[j], key)) {

                arr[j + 1] = arr[j];

                // Count this shift as a movement
                m.move();

                j--;
            }

            // Insert key into its correct position
            arr[j + 1] = key;
        }
    }
}