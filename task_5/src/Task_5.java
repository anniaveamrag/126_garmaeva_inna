import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Task_5 implements Task_5_base {
    @Override
    public ArrayList<Integer> subtask_1_ArrayList(ArrayList<Integer> data, int k, int n) {
        // Выбрать из данного списка элементы, кратные k, но не кратные n
        // и сформировать из них новый список.
        // Вернуть новый список в качестве результата
        ArrayList<Integer> arr = new ArrayList<Integer> ();
        for (int i = 0; i < data.size(); i = i + 1) {
            if ((data.get(i) % k == 0) && (data.get(i) % n != 0)) {
                arr.add(data.get(i)); }
        }
        return arr;
    }

    @Override
    public ArrayList<Integer> subtask_2_ArrayList(int size) {
        // сгенерировать и вернуть список размера size,
        // содержащий первые size элементов последовательности, описанной в
        // задаче subtask_2_for задания task_3
        ArrayList<Integer> arr1 = new ArrayList<Integer> ();
        arr1.add(1);
        if (size == 1)
            return arr1;
        int k = 1;
        for (int i = 2; i <= size; i = i + 1) {
            for (int j = 1; j <= i; j = j + 1) {
                k = k + 1;
                arr1.add(i);
                if (k == size)
                    return arr1; }
        }
        return arr1;
    }

    @Override
    public HashSet<Integer> subtask_3_HashSet(HashSet<Integer> s1, HashSet<Integer> s2) {
        // найдите пересечение множеств s1 и s2
        HashSet<Integer> p = new HashSet<Integer>();
        for (int i : s1)
            for (int j : s2) {
                if (i == j)
                    p.add(i); }
        return p;
    }

    @Override
    public HashSet<Integer> subtask_4_HashSet(HashSet<Integer> s1, HashSet<Integer> s2) {
        // найдите объединение множеств s1 и s2
        HashSet<Integer> o = new HashSet<Integer>();
        o.addAll(s1); o.addAll(s2);
        return o;
    }

    @Override
    public HashSet<Integer> subtask_5_HashSet(HashSet<Integer> s1, HashSet<Integer> s2) {
        // найдите дополнение множества s1 до множества s2
        HashSet<Integer> d = new HashSet<Integer>();
        for (int j : s2) {
            if (!s1.contains(j))
                d.add(j); }
        return d;
    }

    @Override
    public HashSet<Integer> subtask_6_HashSet(HashSet<Integer> s1, HashSet<Integer> s2) {
        // постройте множество, содержащее элементы, содержащиеся либо только в s1,
        // либо только в s2, но не в обоих множествах одновременно
        HashSet<Integer> arr2 = new HashSet<Integer>();
        for (int i : s1)
            if (!s2.contains(i))
                arr2.add(i);
        for (int j : s2)
            if (!s1.contains(j))
                arr2.add(j);
        return arr2;
    }

    @Override
    public HashMap<String, Double> subtask_7_HashMap(ArrayList<String> data) {
        // Дан список строк. Построить словарь, содержащий частоты слов
        // для данного списка в процентах
        HashMap<String, Double> s = new HashMap<>();
        double m;
        for (int i = 0; i < data.size(); i = i + 1) {
            m = 0;
            for (int j = 0; j < data.size(); j = j + 1) {
                if (data.get(i) == data.get(j))
                    m = m + 1; }
            s.put(data.get(i), m/data.size() * 100); }
        return s;
    }

    @Override
    public HashMap<String, Double> subtask_8_HashMap(ArrayList<Double> data) {
        // Дан список чисел. Сформировать словарь, содержащий среднее,
        // максимальное и минимальное значения из данного списка. Ключи
        // словаря "mean", "max", "min" соответственно
        HashMap<String, Double> d = new HashMap<>();
        double min ,max ,mean;
        min = data.get(0);
        max = data.get(0);
        mean = 0;
        for (int i =  0;i < data.size(); i = i + 1) {
            if (min > data.get(i))
                min = data.get(i);
            if (max < data.get(i))
                max = data.get(i);
            mean = mean + data.get(i); }
        mean = mean/data.size();
        d.put("max", max);
        d.put("min",min);
        d.put("mean", mean);
        return d;
    }
}
