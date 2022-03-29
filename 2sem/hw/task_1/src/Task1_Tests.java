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
        DynamicArray<Integer> array = new DynamicArray<>(1);
        array.set(0, 0);
        assertEquals(0, array.get(0).intValue());
    }

    @Test
    public void resize_resizeArray_newSizeIsCorrect() {
        DynamicArray<Integer> array = new DynamicArray<>();
        array.resize(1);
        assertEquals(1, array.getSize());

    }

    @Test
    public void resize_setNegativeValue_NegativeArraySizeException() {
        DynamicArray<Integer> array = new DynamicArray<>();
        var x = assertThrows(NegativeArraySizeException.class, () -> array.resize(-1));
        assertEquals("Size can not be negative", x.getMessage());
        }

    @Test
    public void newArray_getValueOutOfRange_IndexOutOfBoundsException() {
        DynamicArray<Integer> array = new DynamicArray<>(0);
        try {
            array.get(0);
            fail();
        } catch (IndexOutOfBoundsException ex) {
            assertEquals("Index out of bounds", ex.getMessage());
        }
    }

    @Test
    public void newArray_setValueOutOfRange_IndexOutOfBoundsException() {
        DynamicArray<Integer> array = new DynamicArray<>(0);
        try {
            array.set(0, 0);
            fail();
        } catch (IndexOutOfBoundsException ex) {
            assertEquals("Index out of bounds", ex.getMessage());
        }
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void newArray_insertValueOutOfRange_IndexOutOfBoundsException() {
        DynamicArray<Integer> array = new DynamicArray<>(0);
        array.insert(0, 0);
        }

    @Test
    public void newArray_insertValue_Insert() {
        DynamicArray<Integer> array = new DynamicArray<>();
        array.insert(0, 0);
        assertEquals(0, array.get(0).intValue());

    }
    @Test
    public void newArray_insertValue_InsertOne() {
        DynamicArray<Integer> array = new DynamicArray<>(1);
        array.insert(0, 0);
        assertEquals(0, array.get(0).intValue());
    }

    @Test
    public void newArray_pushBackValue_ValueIsCorrect() {
        DynamicArray<Integer> array = new DynamicArray<>(1);
        array.pushBack(0);
        assertEquals(0, array.get(1).intValue());
    }

    @Test (expected = UnsupportedOperationException.class)
    public void newArray_popBackFromEmptyArray_UnsupportedOperationException() {
        DynamicArray<Integer> array = new DynamicArray<>(0);
        array.popBack();
    }

    @Test
    public void removeValue_RemoveOneValue_ValueIsCorrect() {
        DynamicArray<Integer> array = new DynamicArray<>(10);
        array.set(0, 0);
        array.set(1, 1);
        array.remove(1);
        assertEquals(0, array.get(0).intValue());
    }
}
