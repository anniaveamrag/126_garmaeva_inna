import org.junit.*;

public class Task2_Tests extends Assert {
    class TestComparator implements MyComparator<Integer> {
        @Override
        public int compare(Integer first, Integer second) {
            return first - second;
        }
    }

    @Test
    public void bubbleSort_InvertSort() {
        BubbleSort<Integer> bubbleSort = new BubbleSort();
        Integer[] data = {2, 1};
        bubbleSort.sort(data, new TestComparator());
        assertArrayEquals(new Integer[]{1, 2}, data);
    }

    @Test
    public void bubbleSort_DataStaysTheSame() {
        BubbleSort<Integer> bubbleSort = new BubbleSort<>();
        Integer[] data = {1, 2, 3};
        bubbleSort.sort(data, new TestComparator());
        assertArrayEquals(new Integer[]{1, 2, 3}, data);
    }

    @Test
    public void insertionSort_DataStaysTheSame() {
        InsertionSort<Integer> insertionSort = new InsertionSort<>();
        Integer[] data = {1, 2};
        insertionSort.sort(data, new TestComparator());
        assertArrayEquals(new Integer[]{1, 2}, data);
    }

    @Test
    public void selectionSort_InvertSort() {
        SelectionSort<Integer> selectionSort = new SelectionSort<>();
        Integer[] data = {2, 1};
        selectionSort.sort(data, new TestComparator());
        assertArrayEquals(new Integer[]{1, 2}, data);
    }

    @Test
    public void selectionSort_GetSort() {
        SelectionSort<Integer> selectionSort = new SelectionSort<>();
        Integer[] data = {2, 1, 3};
        selectionSort.sort(data, new TestComparator());
        assertArrayEquals(new Integer[]{1, 2, 3}, data);
    }
}
