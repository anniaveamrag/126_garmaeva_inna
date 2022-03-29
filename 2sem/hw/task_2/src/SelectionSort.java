public class SelectionSort<T> implements Sort<T> {
    @Override
    public void sort(T[] data, MyComparator<T> comparator) {
        for(int sortedSize = 0; sortedSize < data.length - 1; ++sortedSize) { // 1
            int maxInd = 0; // 2
            for(int i = 1; i < data.length - sortedSize; ++i) {
                if(comparator.compare(data[i], data[maxInd]) > 0)
                    maxInd = i; // 3
            }
            T tmp = data[data.length - sortedSize - 1]; // 4
            data[data.length - sortedSize - 1] = data[maxInd]; // 5
            data[maxInd] = tmp;
        }
    }
}
