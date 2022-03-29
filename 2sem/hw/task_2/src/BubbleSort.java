public class BubbleSort<T> implements Sort<T> {
    @Override
    public void sort(T[] data, MyComparator<T> comparator) {
        for(int sps = 0; sps < data.length - 1; ++sps) { // 1
            for(int i = 1; i < data.length - sps; ++i) { // 2
                if(comparator.compare(data[i - 1], data[i]) > 0) { // 3
                    T tmp = data[i - 1];
                    data[i - 1] = data[i];
                    data[i] = tmp;
                }
            }
        }
    }
}
