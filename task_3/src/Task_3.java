public class Task_3 implements Task_3_base {
    @Override
    public int subtask_1_for(int n1, int n2, int a, int b) {
        // подсчитать, сколько чисел, кратных a, но не кратных b,
        // находится между числами n1 и n2 включительно
        int count = 0; int poof = n1;
        if (poof > n2) {
            n1 = n2; n2 = poof; }
        for (int p = n1; p <= n2; p = p + 1) {
            if ((p % a) == 0 && (p % b) != 0)
                count = count + 1;
        }
        return count;
    }

    @Override
    public int subtask_2_for(int num) {
        // Последовательность чисел строится следующим образом:
        // сначала идет одна единица,
        // потом две двойки,
        // потом три тройки,
        // ...
        // потом n раз число n
        // ...
        // Найти, какое число будет находиться в этой последовательности
        // на позиции num
        int ooh = 0;
        for (int i = 1; i <= num; i = i + 1) {
            for (int j = 0; j < i; j = j + 1) {
                ooh = ooh + 1;
                if (num == ooh)
                    return i;
            }
        }
        return num;
    }

    @Override
    public int subtask_3_for(int num, int d, int cnt) {
        // Дана последовательность
        // a(0) = num
        // a(n) = a(n - 1) * d + 1
        // Найти сумму первых cnt элементов последовательности
        int sum = 0; int n = num;
        for (int i = 1; i <= cnt; i = i + 1) {
            sum = sum + n;
            n = n * d + 1;
        }
        return sum;
    }

    @Override
    public int subtask_4_for(int n) {
        // Вычислить сумму
        // S(n) = 1 + 1 * 2 + 1 * 2 * 3 + ... + n!
        // для заданного n
        // (n! - это n-факториал. Кто не знает - гуглите)
        int poo = 0;
        if (n == 0)
            return 1;
        for (int i = 1; i <= n; i = i + 1) {
            int fact = 1;
            for (int j = 2; j <= i; j = j + 1) {
                fact = fact * j;
            }
            poo = poo + fact;
        }

        return poo;
    }
}
