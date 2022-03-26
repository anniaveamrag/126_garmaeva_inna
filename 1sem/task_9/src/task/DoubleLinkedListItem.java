package task;

public class DoubleLinkedListItem<T extends Comparable<T>> {
    private T data;
    private DoubleLinkedListItem Next;
    private DoubleLinkedListItem Prev;
    public DoubleLinkedListItem(T data) {
        this.data = data; }
    public T getData() {
        return data; }
    public DoubleLinkedListItem getNext() {
        return Next; }
    public DoubleLinkedListItem getPrev() {
        return Prev; }
    public void setData(T data) {
        this.data = data; }
    public void setNext(DoubleLinkedListItem Next) {
        this.Next = Next; }
    public void setPrev(DoubleLinkedListItem Prev) {
        this.Prev = Prev; }
}
