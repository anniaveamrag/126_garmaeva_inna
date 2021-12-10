package task;

public class DoubleLinkedListSorter {
    public static <T extends Comparable<T>> void sort(DoubleLinkedList<T> list) {
        for (int i = 0; i < list.getSize(); i++) {
            DoubleLinkedListItem a = list.getFirst();
            DoubleLinkedListItem b = list.getFirst();
            for (int j = 0; j < list.getSize()-i; j++) {
                if(b.getData().compareTo(a.getData()) <0){
                    a = b; }
                b = b.getNext(); }
            list.remove(a);
            list.insertAfter(list.getLast(), (T)a.getData());
        }
    }
}
