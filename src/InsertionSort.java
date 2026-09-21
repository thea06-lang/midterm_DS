/** P3: Insertion Sort. Shifts are movements: call m.move() for each shift, not m.swap(). */
public class InsertionSort implements Sorter {
    @Override
    public String name() { return "Insertion Sort"; }

    @Override
    public boolean isQuadratic() { return true; }

    @Override
    public void sort(int[] arr, Metrics m) {
        for (int i = 1; i < arr.length; i++) {
            int value = arr[i];
            int position = i;

            while (position > 0) {
                if (!m.greater(arr[position - 1], value)) {
                    break;
                }
                arr[position] = arr[position - 1];
                m.move();
                position--;
            }

            arr[position] = value;
        }
    }
}
