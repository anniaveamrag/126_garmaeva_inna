import org.junit.*;

public class Task3_Tests extends Assert {
    class TestComparator implements MyComparator<Integer> {
        @Override
        public int compare(Integer first, Integer second) {
            return first - second;
        }
    }

    @Test
    public void HeapSort_InterchangeIndex() {
        HeapSort<Integer> heapSort = new HeapSort();
        Integer[] data = {2, 1};
        heapSort.sort(data, new TestComparator());
        assertArrayEquals(new Integer[]{1, 2}, data);
    }

    @Test
    public void HeapSort_Sort_TakeTwo() {
        HeapSort<Integer> heapSort = new HeapSort();
        Integer[] data = {1, 2};
        heapSort.sort(data, new TestComparator());
        assertArrayEquals(new Integer[]{1, 2}, data);
    }

    @Test
    public void HeapSort_Sort_TakeThree() {
        HeapSort<Integer> heapSort = new HeapSort();
        Integer[] data = {2, 1, 3};
        heapSort.sort(data, new TestComparator());
        assertArrayEquals(new Integer[]{1, 2, 3}, data);
    }

    @Test
    public void HeapSort_UnsortedSort_TakeOne() {
        HeapSort<Integer> heapSort = new HeapSort();
        Integer[] data = {3, 1, 1, 1, 2};
        heapSort.sort(data, new TestComparator());
        assertArrayEquals(new Integer[]{1, 1, 1, 2, 3}, data);
    }

    @Test
    public void HeapSort_UnsortedSort_TakeTwo() {
        HeapSort<Integer> heapSort = new HeapSort();
        Integer[] data = {4, 1, 1, 3, 3, 2};
        heapSort.sort(data, new TestComparator());
        assertArrayEquals(new Integer[]{1, 1, 2, 3, 3, 4}, data);
    }

    @Test
    public void MergeSort_UnsortedSort_TakeOne() {
        MergeSort<Integer> mergeSort = new MergeSort();
        Integer[] data = {2, 1, 3};
        mergeSort.sort(data, new TestComparator());
        assertArrayEquals(new Integer[]{1, 2, 3}, data);
    }

    @Test
    public void MergeSort_UnsortedSort_TakeTwo() {
        MergeSort<Integer> mergeSort = new MergeSort();
        Integer[] data = {4, 1, 1, 3, 3, 4, 4, 2};
        mergeSort.sort(data, new TestComparator());
        assertArrayEquals(new Integer[]{1, 1, 2, 3, 3, 4, 4, 4}, data);
    }

    @Test
    public void MergeSort_InterchangeIndex() {
        MergeSort<Integer> mergeSort = new MergeSort();
        Integer[] data = {2, 1};
        mergeSort.sort(data, new TestComparator());
        assertArrayEquals(new Integer[]{1, 2}, data);
    }

    @Test
    public void MergeSort_UnsortedSort_TakeFour() {
        MergeSort<Integer> mergeSort = new MergeSort();
        Integer[] data = {3, 1, 1, 1, 1, 2};
        mergeSort.sort(data, new TestComparator());
        assertArrayEquals(new Integer[]{1, 1, 1, 1, 2, 3}, data);
    }

    @Test
    public void MergeSort_UnsortedSort_TakeThree() {
        MergeSort<Integer> mergeSort = new MergeSort();
        Integer[] data = {1, 1, 2, 3};
        mergeSort.sort(data, new TestComparator());
        assertArrayEquals(new Integer[]{1, 1, 2, 3}, data);
    }

    @Test
    public void QuickSort_InterchangeIndex() {
        try {
            Integer[] data = new Integer[]{2,1};
            QuickSort quickSort = new QuickSort();
            quickSort.sort(data, new TestComparator());
            assertArrayEquals(new Integer[]{1, 2}, data);
        }catch (Exception e){
            fail();
        }
    }

    @Test
    public void QuickSort_UnsortedSort_TakeOne(){
        try {
            Integer[] data = new Integer[]{1,2,3,4,5,4,3,2,1};
            QuickSort quickSort = new QuickSort();
            quickSort.sort(data, new TestComparator());
            assertArrayEquals(new Integer[]{1,1,2,2,3,3,4,4,5}, data);
        } catch (Exception e){
            fail();
        }
    }
    @Test
    public void QuickSort_UnsortedSort_TakeTwo(){
        try {
            Integer[] data = new Integer[]{1,4,2,6,3,2,6,3,5,4,1,2,2,5,4,2,3};
            QuickSort quickSort = new QuickSort();
            quickSort.sort(data, new TestComparator());
            assertArrayEquals(new Integer[]{1,1,2,2,2,2,2,3,3,3,4,4,4,5,5,6,6}, data);
        }catch (Exception e){
            fail();
        }
    }
}
