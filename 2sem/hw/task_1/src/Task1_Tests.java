import org.junit.*;

public class Task1_Tests extends Assert {
    // Тесты динамического массива
    @Test
    public void newArray_getSizeOfNewArray_SizeEqualsDefaultSize() {
        DynamicArray<Integer> array = new DynamicArray<>();
        assertEquals(1024, array.getSize());
    }

    @Test
    public void arraySet_setArrayValues_ValuesAreCorrect() {
        DynamicArray<Integer> array = new DynamicArray<>(1024);
        array.set(0, 100);
        assertEquals(100, array.get(0).intValue());
    }

    @Test
    public void resize_resizeArray_newSizeIsCorrect() {
        DynamicArray<Integer> array = new DynamicArray<>(1024);
        array.resize(2048);
        assertEquals(2048, array.getSize());

    }

    @Test
    public void resize_setNegativeValue_NegativeArraySizeException() {
        DynamicArray<Integer> array = new DynamicArray<>(1024);
        try {
            array.resize(-1);
            fail();
        } catch (NegativeArraySizeException ex) {
            assertEquals("Size can not be negative", ex.getMessage());
        }
    }

    @Test
    public void newArray_getValueOutOfRange_IndexOutOfBoundsException() {
        DynamicArray<Integer> array = new DynamicArray<>(1024);
        try {
            array.get(1024);
            fail();
        } catch (IndexOutOfBoundsException ex) {
            assertEquals("Index out of bounds", ex.getMessage());
        }
    }

    @Test
    public void newArray_setValueOutOfRange_IndexOutOfBoundsException() {
        DynamicArray<Integer> array = new DynamicArray<>(1024);
        try {
            array.set(1024, 100);
            fail();
        } catch (IndexOutOfBoundsException ex) {
            assertEquals("Index out of bounds", ex.getMessage());
        }
    }

    @Test
    public void newArray_insertValueOutOfRange_IndexOutOfBoundsException() {
        DynamicArray<Integer> array = new DynamicArray<>(1024);
        try {
            array.insert(1024, 100);
            fail();
        } catch (IndexOutOfBoundsException ex) {
            assertEquals("Index out of bounds", ex.getMessage());
        }
    }

    @Test
    public void newArray_insertValue_ValueMeetsIndex() {
        DynamicArray<Integer> array = new DynamicArray<>(1024);
        array.set(0, 100);
        array.set(1, 101);
        array.insert(1, 200);
        assertEquals(100, array.get(0).intValue());
        assertEquals(200, array.get(1).intValue());

    }

    @Test
    public void newArray_pushBackValue_ValueIsCorrect() {
        DynamicArray<Integer> array = new DynamicArray<>(1024);
        array.set(0, 100);
        array.pushBack(4000);
        assertEquals(4000, array.get(1024).intValue());
    }

    @Test
    public void newArray_popBackFromEmptyArray_UnsupportedOperationException() {
        try {
            DynamicArray<Integer> array = new DynamicArray<>(0);
            array.popBack();
            fail();
        } catch (UnsupportedOperationException ex) {
            assertEquals("Array is empty", ex.getMessage());
        }
    }

    @Test
    public void removeValue_RemoveOneValue_ValueIsCorrect() {
        DynamicArray<Integer> array = new DynamicArray<>(1024);
        array.set(0, 100);
        array.set(1, 200);
        array.remove(1);
        assertEquals(100, array.get(0).intValue());
    }
}
