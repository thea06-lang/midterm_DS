
/** P1 (Kunthea): Heap Sort. We'll write this together. */
public class HeapSort implements Sorter {
    public String name() { return "Heap Sort"; }
    public String extraLabel() { return "heapify calls"; }

    public void sort(int[] arr, Metrics m) {
        // TODO (P1): phase 1 - build a max-heap
        int n = arr.length;
        //starts at index n/2 -1 and work your way own to swap if needed
        for (int i = n / 2 -1; i >= 0; i--) {
            //look at the box my finger points to, and fix it if it's smaller than its children
            heapify(arr, n, i, m);
        }
        // TODO (P1): phase 2 - swap root to the end, shrink heap, heapify again
        for (int end = n - 1; end > 0; end--){
            m.swap(arr, 0, end); //1. swap the biggest (always box 0) to the back
            heapify(arr, end, 0, m); // 2. fix box 0 again, but only look at boxes before end
            //the end tells heapify how big the heap is now so it ignores the sorted boxes behind the wall.
        }
    }
    //when calling heapify, it recieves 4 things: arr (box), heapSize (where the wall is), root (starting box)
    //m (notebook that counts comparisions and swaps
    private void heapify(int[] arr, int heapSize, int root, Metrics m) {
        // TODO (P1): call m.countExtra() once here, then sift root down

        //Set up
        m.countExtra(); //write "+1 heapify call" in the notebook
        int parent = root; //put our finger on the starting box

        while (true) {
            //Find the children
            int left = 2 * parent + 1;
            int right = left + 1;

            //who's the biggest?
            //start assuming the the parent is the biggest
            int largest = parent;

            //testing assuming
            //is the left/right child's index smaller than heapSize?
            //if it does, is the left/right value greater than the largest value?
            // if yes, than the left/right value will turn into the largest value
            if (left < heapSize && m.greater(arr[left], arr[largest])) largest = left;
            if (right < heapSize && m.greter(arr[right], arr[largest])) largest = right;

            //Decide
            //if parent is still the biggest, we're done
            if (largest == parent) break;
            //otherwise, swap parent with the bigger child
            m.swap(arr, parent, largest);
            //move the finger down to where it landed
            parent = largest;
        }

    }
}
