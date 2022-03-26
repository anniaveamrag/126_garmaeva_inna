import java.util.Arrays;

public class DynamicArray<T> {
    private int size;
    private int capacity;
    private Object[] data;
    public static final int DefaultSize = 1024;

    public DynamicArray() {
        data = new Object[DefaultSize];
        size = DefaultSize ; // 1
        capacity = DefaultSize;
    }
    public DynamicArray(int size) {
        data = new Object[size]; // 2
        this.size = size;
        capacity = size;
    }

    public void resize(int newSize) {
        if(newSize < 0) // 3
            throw new NegativeArraySizeException("Size can not be negative");
        if(newSize != capacity) {
            capacity = newSize;
            data = Arrays.copyOf(data, newSize);
        }
        size = newSize; // 4
    }
    public T get(int index) {
        if(index < 0 || index >= size) // 5
            throw new IndexOutOfBoundsException("Index out of bounds");
        return (T)data[index];
    }
    public void set(int index, T value) {
        if(index < 0 || index >= size) // 6
            throw new IndexOutOfBoundsException("Index out of bounds");
        data[index] = value;
    }
    public void insert(int index, T value) {
        if(index < 0 || index >= size) // 7
            throw new IndexOutOfBoundsException("Index out of bounds");
        if(capacity <= size) { // 8
            data = Arrays.copyOf(data, size * 2);
            capacity = size * 2;
        }
        for(int i = size - 1; i >= index; --i)
            data[i + 1] = data[i];
        ++size;
        data[index] = value; // 9
    }
    public void pushBack(T value) {
        if(capacity <= size) { // 10
            data = Arrays.copyOf(data, size * 2);
            capacity = size * 2;
        }
        data[size] = value; // 11
        ++size;
    }
    public void popBack() {
        if(size <= 0) // 12
            throw new UnsupportedOperationException("Array is empty");
        --size;
        data[size] = null;
    }
    public void remove(int index) {
        if(index < 0 || index >= size) // 13
            throw new IndexOutOfBoundsException("Index out of bounds");
        for(int i = index + 1; i < size; ++i)
            data[i - 1] = data[i];
        --size;
        data[size] = null;
    }
    public int getSize() {
        return size;
    }
}
