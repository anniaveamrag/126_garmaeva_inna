package task;

public class DoubleLinkedList<T extends Comparable<T>> {
    private DoubleLinkedListItem First;
    private DoubleLinkedListItem Last;
    private int Size;
    public DoubleLinkedList(){
        Size = 0; }
    public DoubleLinkedListItem findFirstItem(T data){
        DoubleLinkedListItem item = First;
        while (item.getData() != data){
            item = item.getNext(); }
        return item; }
    public DoubleLinkedListItem findLastItem(T data){
        DoubleLinkedListItem item = Last;
        while(item.getData() != data){
            item = item.getPrev(); }
        return item; }
    public void insertAfter(DoubleLinkedListItem item, T data){
        DoubleLinkedListItem newItem = new DoubleLinkedListItem(data);
        if (item == null && Size == 0) {
            First = newItem;
            Last = newItem; }
        else if (item == null && Size != 0) {
            insertBefore(First,data);
            Size--; }
        else if (item.getNext() == null) {
            item.setNext(newItem);
            newItem.setPrev(item);
            Last = newItem; }
        else {
            newItem.setNext(item.getNext());
            newItem.setPrev(item);
            item.getNext().setPrev(newItem);
            item.setNext(newItem);
        }
        Size++;
    }
    public void insertBefore(DoubleLinkedListItem item, T data){
        DoubleLinkedListItem newItem = new DoubleLinkedListItem(data);
        if (item == null && Size == 0) {
            First = newItem;
            Last = newItem; }
        else if (item == null && Size != 0) {
            insertAfter(Last,data);
            Size--; }
        else if (item.getPrev() == null) {
            item.setPrev(newItem);
            newItem.setNext(item);
            First = newItem; }
        else {
            newItem.setPrev(item.getPrev());
            newItem.setNext(item);
            item.getPrev().setNext(newItem);
            item.setPrev(newItem); }
        Size++;
    }
    public void remove(DoubleLinkedListItem item){
        if ((item.getNext() == null) && (item.getPrev() == null)) {
            Last = null;
            First = null; }
        else if (item.getNext() == null) {
            item.getPrev().setNext(null);
            Last = item.getPrev(); }
        else if (item.getPrev() == null) {
            item.getNext().setPrev(null);
            First = item.getNext(); }
        else {
            item.getNext().setPrev(item.getPrev());
            item.getPrev().setNext(item.getNext());
            item.setNext(null);
            item.setPrev(null); }
        Size--;
    }
    public int getSize() {
        return Size;
    }
    public DoubleLinkedListItem getFirst(){
        return First;
    }
    public DoubleLinkedListItem getLast(){
        return Last;
    }
}

