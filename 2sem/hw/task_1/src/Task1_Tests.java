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

    @Test(expected = IndexOutOfBoundsException.class)
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

    @Test(expected = UnsupportedOperationException.class)
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

    private int GetIntValue(ListNode<Integer> item) {
        return ((Node<Integer>) item).getData();
    }

    @Test
    public void PushFront_DoubleLinkedList_TakeOne() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        list.pushFront(1);
        assertFalse(list.isEmpty());
    }

    @Test
    public void PushFront_DoubleLinkedList_TakeTwo() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        list.pushFront(1);
        try {
            list.get(1);
            fail();
        } catch (IndexOutOfBoundsException e) {
            assertTrue(true);
        }
    }

    @Test
    public void PushFront_DoubleLinkedList_FirstItemIsCorrect() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        list.pushFront(1);
        list.pushFront(2);
        list.pushFront(3);
        assertEquals(1, GetIntValue(list.get(0)));
    }

    @Test
    public void PushFront_DoubleLinkedList_SecondItemIsCorrect() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        list.pushFront(1);
        list.pushFront(2);
        list.pushFront(3);
        assertEquals(2, GetIntValue(list.get(1)));
    }

    @Test
    public void PushFront_DoubleLinkedList_ThirdItemIsCorrect() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        list.pushFront(1);
        list.pushFront(2);
        list.pushFront(3);
        assertEquals(3, GetIntValue(list.get(2)));
    }

    @Test
    public void PushFront_DoubleLinkedList_HeadIsCorrect() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        list.pushFront(1);
        list.pushFront(2);
        list.pushFront(3);
        assertEquals(1, GetIntValue(list.getHead()));
    }

    @Test
    public void PushFront_DoubleLinkedList_TailIsCorrect() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        list.pushFront(1);
        list.pushFront(2);
        list.pushFront(3);
        assertEquals(3, GetIntValue(list.getTail()));
    }

    @Test
    public void PushBack_DoubleLinkedList_FirstItemIsCorrect() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        list.pushBack(3);
        list.pushBack(2);
        list.pushBack(1);
        assertEquals(1, GetIntValue(list.get(0)));
    }

    @Test
    public void PushBack_DoubleLinkedList_SecondItemIsCorrect() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        list.pushBack(3);
        list.pushBack(2);
        list.pushBack(1);
        assertEquals(2, GetIntValue(list.get(1)));
    }

    @Test
    public void PushBack_DoubleLinkedList_ThirdItemIsCorrect() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        list.pushBack(3);
        list.pushBack(2);
        list.pushBack(1);
        assertEquals(3, GetIntValue(list.get(2)));
    }

    @Test
    public void RemoveItem_DoubleLinkedList_FirstItemIsCorrect() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        list.pushFront(1);
        list.pushFront(2);
        list.pushFront(3);
        list.remove(list.get(0));
        assertEquals(2, GetIntValue(list.get(0)));
    }

    @Test
    public void RemoveItem_DoubleLinkedList_HeadIsCorrect() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        list.pushFront(1);
        list.pushFront(2);
        list.pushFront(3);
        list.remove(list.get(0));
        assertEquals(2, GetIntValue(list.getHead()));
    }

    @Test
    public void RemoveItem_DoubleLinkedList_TailIsCorrect() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        list.pushFront(1);
        list.pushFront(2);
        list.pushFront(3);
        list.remove(list.get(0));
        assertEquals(3, GetIntValue(list.getTail()));
    }

    @Test
    public void RemoveItem_DoubleLinkedList_SizeIsCorrect() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        list.pushFront(1);
        list.pushFront(2);
        list.pushFront(3);
        list.remove(list.get(0));
        assertEquals(2, list.getSize());
    }

    @Test
    public void InsertList_DoubleLinkedList_SizeIsCorrect() {
        DoubleLinkedList<Integer> list1 = new DoubleLinkedList<>();
        list1.pushFront(1);
        list1.pushFront(2);
        list1.pushFront(3);

        DoubleLinkedList<Integer> list2 = new DoubleLinkedList<>();
        list2.pushFront(4);
        list2.pushFront(5);
        list2.pushFront(6);
        list1.insertListAfter(list1.get(0), list2);
        assertEquals(6, list1.getSize());
    }

    @Test
    public void InsertList_DoubleLinkedList_HeadIsCorrect() {
        DoubleLinkedList<Integer> list1 = new DoubleLinkedList<>();
        list1.pushFront(1);
        list1.pushFront(2);
        list1.pushFront(3);

        DoubleLinkedList<Integer> list2 = new DoubleLinkedList<>();
        list2.pushFront(4);
        list2.pushFront(5);
        list2.pushFront(6);
        list1.insertListAfter(list1.get(0), list2);
        assertEquals(1, GetIntValue(list1.getHead()));
    }

    @Test
    public void InsertList_DoubleLinkedList_TailIsCorrect() {
        DoubleLinkedList<Integer> list1 = new DoubleLinkedList<>();
        list1.pushFront(1);
        list1.pushFront(2);
        list1.pushFront(3);

        DoubleLinkedList<Integer> list2 = new DoubleLinkedList<>();
        list2.pushFront(4);
        list2.pushFront(5);
        list2.pushFront(6);
        list1.insertListAfter(list1.get(0), list2);
        assertEquals(3, GetIntValue(list1.getTail()));
    }

    @Test
    public void InsertList_DoubleLinkedList_AllElementsAreCorrect() {
        DoubleLinkedList<Integer> list1 = new DoubleLinkedList<>();
        list1.pushFront(1);
        list1.pushFront(2);
        list1.pushFront(3);

        DoubleLinkedList<Integer> list2 = new DoubleLinkedList<>();
        list2.pushFront(4);
        list2.pushFront(5);
        list2.pushFront(6);

        list1.insertListAfter(list1.get(0), list2);

        assertEquals(1, GetIntValue(list1.get(0)));
        assertEquals(4, GetIntValue(list1.get(1)));
        assertEquals(5, GetIntValue(list1.get(2)));
        assertEquals(6, GetIntValue(list1.get(3)));
        assertEquals(2, GetIntValue(list1.get(4)));
        assertEquals(3, GetIntValue(list1.get(5)));
    }

    @Test
    public void InsertList_DoubleLinkedList_AllElementsAreCorrect2() {
        DoubleLinkedList<Integer> list1 = new DoubleLinkedList<>();
        list1.pushFront(1);
        list1.pushFront(2);
        list1.pushFront(3);

        DoubleLinkedList<Integer> list2 = new DoubleLinkedList<>();
        list2.pushFront(4);
        list2.pushFront(5);
        list2.pushFront(6);

        list1.insertListAfter(list1.get(1), list2);

        assertEquals(1, GetIntValue(list1.get(0)));
        assertEquals(2, GetIntValue(list1.get(1)));
        assertEquals(4, GetIntValue(list1.get(2)));
        assertEquals(5, GetIntValue(list1.get(3)));
        assertEquals(6, GetIntValue(list1.get(4)));
        assertEquals(3, GetIntValue(list1.get(5)));
    }

    @Test
    public void InsertList_DoubleLinkedList_AllElementsAreCorrect3() {
        DoubleLinkedList<Integer> list1 = new DoubleLinkedList<>();
        list1.pushFront(1);
        list1.pushFront(2);
        list1.pushFront(3);

        DoubleLinkedList<Integer> list2 = new DoubleLinkedList<>();
        list2.pushFront(4);
        list2.pushFront(5);
        list2.pushFront(6);

        list1.insertListAfter(list1.get(2), list2);

        assertEquals(1, GetIntValue(list1.get(0)));
        assertEquals(2, GetIntValue(list1.get(1)));
        assertEquals(3, GetIntValue(list1.get(2)));
        assertEquals(4, GetIntValue(list1.get(3)));
        assertEquals(5, GetIntValue(list1.get(4)));
        assertEquals(6, GetIntValue(list1.get(5)));
    }

    @Test
    public void InsertList_DoubleLinkedList_HeadIsCorrect2() {
        DoubleLinkedList<Integer> list1 = new DoubleLinkedList<>();
        list1.pushFront(1);
        list1.pushFront(2);
        list1.pushFront(3);

        DoubleLinkedList<Integer> list2 = new DoubleLinkedList<>();
        list2.pushFront(4);
        list2.pushFront(5);
        list2.pushFront(6);
        list1.insertListAfter(list1.get(2), list2);
        assertEquals(1, GetIntValue(list1.getHead()));
    }

    @Test
    public void InsertList_DoubleLinkedList_TailIsCorrect2() {
        DoubleLinkedList<Integer> list1 = new DoubleLinkedList<>();
        list1.pushFront(1);
        list1.pushFront(2);
        list1.pushFront(3);

        DoubleLinkedList<Integer> list2 = new DoubleLinkedList<>();
        list2.pushFront(4);
        list2.pushFront(5);
        list2.pushFront(6);
        list1.insertListAfter(list1.get(2), list2);
        assertEquals(6, GetIntValue(list1.getTail()));
    }

    @Test
    public void InsertList_DoubleLinkedList_SizeIsCorrect2() {
        DoubleLinkedList<Integer> list1 = new DoubleLinkedList<>();
        list1.pushFront(1);
        list1.pushFront(2);
        list1.pushFront(3);

        DoubleLinkedList<Integer> list2 = new DoubleLinkedList<>();
        list2.pushFront(4);
        list2.pushFront(5);
        list2.pushFront(6);
        list1.insertListBefore(list1.get(0), list2);
        assertEquals(6, list1.getSize());
    }

    @Test
    public void InsertList_DoubleLinkedList_HeadIsCorrect3() {
        DoubleLinkedList<Integer> list1 = new DoubleLinkedList<>();
        list1.pushFront(1);
        list1.pushFront(2);
        list1.pushFront(3);

        DoubleLinkedList<Integer> list2 = new DoubleLinkedList<>();
        list2.pushFront(4);
        list2.pushFront(5);
        list2.pushFront(6);
        list1.insertListBefore(list1.get(0), list2);
        assertEquals(4, GetIntValue(list1.getHead()));
    }

    @Test
    public void InsertList_DoubleLinkedList_TailIsCorrect3() {
        DoubleLinkedList<Integer> list1 = new DoubleLinkedList<>();
        list1.pushFront(1);
        list1.pushFront(2);
        list1.pushFront(3);

        DoubleLinkedList<Integer> list2 = new DoubleLinkedList<>();
        list2.pushFront(4);
        list2.pushFront(5);
        list2.pushFront(6);
        list1.insertListBefore(list1.get(0), list2);
        assertEquals(3, GetIntValue(list1.getTail()));
    }

    @Test
    public void InsertList_DoubleLinkedList_EverythingIsCorrect() {
        DoubleLinkedList<Integer> list1 = new DoubleLinkedList<>();
        list1.pushFront(1);
        list1.pushFront(2);
        list1.pushFront(3);

        DoubleLinkedList<Integer> list2 = new DoubleLinkedList<>();
        list2.pushFront(4);
        list2.pushFront(5);
        list2.pushFront(6);

        list1.insertListBefore(list1.get(0), list2);

        assertEquals(4, GetIntValue(list1.get(0)));
        assertEquals(5, GetIntValue(list1.get(1)));
        assertEquals(6, GetIntValue(list1.get(2)));
        assertEquals(1, GetIntValue(list1.get(3)));
        assertEquals(2, GetIntValue(list1.get(4)));
        assertEquals(3, GetIntValue(list1.get(5)));
    }

    @Test
    public void InsertList_DoubleLinkedList_EverythingIsCorrect2() {
        DoubleLinkedList<Integer> list1 = new DoubleLinkedList<>();
        list1.pushFront(1);
        list1.pushFront(2);
        list1.pushFront(3);

        DoubleLinkedList<Integer> list2 = new DoubleLinkedList<>();
        list2.pushFront(4);
        list2.pushFront(5);
        list2.pushFront(6);

        list1.insertListBefore(list1.get(1), list2);

        assertEquals(1, GetIntValue(list1.get(0)));
        assertEquals(4, GetIntValue(list1.get(1)));
        assertEquals(5, GetIntValue(list1.get(2)));
        assertEquals(6, GetIntValue(list1.get(3)));
        assertEquals(2, GetIntValue(list1.get(4)));
        assertEquals(3, GetIntValue(list1.get(5)));
    }

    @Test
    public void InsertList_DoubleLinkedList_EverythingIsCorrect3() {
        DoubleLinkedList<Integer> list1 = new DoubleLinkedList<>();
        list1.pushFront(1);
        list1.pushFront(2);
        list1.pushFront(3);

        DoubleLinkedList<Integer> list2 = new DoubleLinkedList<>();
        list2.pushFront(4);
        list2.pushFront(5);
        list2.pushFront(6);

        list1.insertListBefore(list1.get(2), list2);

        assertEquals(1, GetIntValue(list1.get(0)));
        assertEquals(2, GetIntValue(list1.get(1)));
        assertEquals(4, GetIntValue(list1.get(2)));
        assertEquals(5, GetIntValue(list1.get(3)));
        assertEquals(6, GetIntValue(list1.get(4)));
        assertEquals(3, GetIntValue(list1.get(5)));
    }

    @Test
    public void InsertList_DoubleLinkedList_HeadIsCorrect4() {
        DoubleLinkedList<Integer> list1 = new DoubleLinkedList<>();
        list1.pushFront(1);
        list1.pushFront(2);
        list1.pushFront(3);

        DoubleLinkedList<Integer> list2 = new DoubleLinkedList<>();
        list2.pushFront(4);
        list2.pushFront(5);
        list2.pushFront(6);
        list1.insertListBefore(list1.get(2), list2);
        assertEquals(1, GetIntValue(list1.getHead()));
    }

    @Test
    public void InsertList_DoubleLinkedList_TailIsCorrect4() {
        DoubleLinkedList<Integer> list1 = new DoubleLinkedList<>();
        list1.pushFront(1);
        list1.pushFront(2);
        list1.pushFront(3);

        DoubleLinkedList<Integer> list2 = new DoubleLinkedList<>();
        list2.pushFront(4);
        list2.pushFront(5);
        list2.pushFront(6);
        list1.insertListBefore(list1.get(2), list2);
        assertEquals(3, GetIntValue(list1.getTail()));

    }
}
