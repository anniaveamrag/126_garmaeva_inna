import java.util.Arrays;
public class Task_4 implements Task_4_base {
    @Override
    public int[] subtask_1_arrays(int size, int a0, int d) {
        // сгенерировать и вернуть массив размера size, содержащий элементы
        // арифметической прогрессии с первым членом a0 и разностью d
        int[] array = new int[size];
        array[0] = a0;
        for (int i = 1; i < size; i = i + 1) {
            array[i] = array[0] + d * i;
        }
        return array;
    }

    @Override
    public int[] subtask_2_arrays(int size) {
        // сгенерировать и вернуть массив размера size, первые два элемента
        // которого равны единице, а каждый следующий - сумме всех предыдущих
        int[] arr = new int[size];
        arr[0] = 1;
        if (size > 1) {
            arr[1] = 1;
            for (int i = 2; i < size; i = i + 1) {
                arr[1] = 1;
                arr[i] = arr[i - 1] * 2;
            }
        }
        return arr;
    }

    @Override
    public int[] subtask_3_arrays(int size) {
        // сгенерировать и вернуть массив размера size, содержащий первые
        // size чисел последовательности фибоначчи.
        // https://ru.wikipedia.org/wiki/Числа_Фибоначчи
        int [] a = new int [size];
        a [0] = 0;
        if (size > 1) {
            a[1] = 1;
            for (int i = 2; i < size; i = i + 1) {
                a[i] = a[i - 1] + a[i - 2];
            }
        }
        return a;
    }

    @Override
    public int subtask_4_arrays(int[] data) {
        // Для данного массива вычислить максимальный элемент
        int b = data[0];
        for (int i = 1; i < data.length; i = i + 1) {
            if (data[i] > b)
                b = data[i];
        }
        return b;
    }

    @Override
    public int subtask_5_arrays(int[] data, int k) {
        // Для данного массива вычислить максимальный элемент
        // кратный k. Гарантируется, что как минумум один такой элемент
        // в массиве есть
        int c = -222222222;
        for (int i = 1; i < data.length; i = i + 1) {
            if ((data[i] > c) && (data[i] % k == 0))
                c = data[i];
        }
        return c;
    }

    @Override
    public int[] subtask_6_arrays(int[] arr1, int[] arr2) {
        // Даны два массива arr1, arr2.
        // Произвести слияние данных массивов в один отсортированный
        // по возрастанию массив.
        int[] array = new int[arr1.length + arr2.length];
        for (int i = 0; i < arr1.length; i = i + 1) {
            array[i] = arr1[i];
        }
        for (int i = 0; i < arr2.length; i = i + 1) {
            array[i + arr1.length] = arr2[i];
        }
        Arrays.sort(array);
        return array;
    }

    @Override
    public int[] subtask_7_arrays(int[] arr1, int[] arr2) {
        // Даны два отсортированных по возрастанию массива arr1, arr2.
        // Произвести слияние данных массивов в один также отсортированный
        // по возрастанию массив.
        // Используйте алгоритм, время работы которого будет пропорционально сумме
        // размеров arr1 и arr2, а не их произведению
        int [] arr = new int[arr1.length+ arr2.length];
        int s = 0; int m =0; int i = 0;
        while (i < (arr1.length + arr2.length)) {
            if (((m >= arr2.length) || ((s < arr1.length)) && arr1[m] < arr2[s])) {
                arr[i] = arr1[s];
                s = s + 1;
            }
            else {
                arr[i] = arr2[m];
                m = m + 1; }
            i = i + 1; }
        return arr;
    }
}
