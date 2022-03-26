import java.util.Scanner;

public class Task_2 implements Task_2_base {
    @Override
    public int subtask_1_while(int num) {
        // Найти максимальное число, являющееся полным квадратом,
        // не превосходящее заданное натуральное num
        int a = 0;
        while (a * a <= num) {
            a = a + 1;
        }
        a = a - 1;
        return (a * a);
    }

    @Override
    public int subtask_2_while(int num) {
        // Последовательность целых чисел p(n) определяется следующим образом:
        // p(0) = 1
        // p(k) = 2 * p(k - 1) + 6, k > 0
        //Найти элемент последовательности с номером num
        int p = 1;
        int k = 1;
        if (num == 0)
            return 1;
        while (k <= num) {
            p = 2 * p + 6;
            k = k + 1;
        }
        return p;
    }

    @Override
    public boolean subtask_3_while(int num, int base) {
        // Проверить, является ли число num натуральной степенью числа base
        int b = base;
        while (b < num) {
            b = b * base;
        }
        return b == num;
    }

    @Override
    public int subtask_4_while(int start, int end) {
        // Вычислить, за какое минимальное число операций
        // вычесть 1
        // поделить на 2
        // число start можно превратить в end. Гарантируется, что start >= end >= 1
        int c = 0;
        while (start > end) {
            while ((start % 2) == 0 && (start / 2) >= end) {
                start = start / 2;
                c = c + 1;
            }
            if (start > end) {
                c = c + 1;
                start = start - 1;
            }
        }
        return c;
    }
}
