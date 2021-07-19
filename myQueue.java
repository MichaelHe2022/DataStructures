import java.util.NoSuchElementException;

public class myQueue<T> {
    
    private class QueueNode<T> {
        private T data;
        private QueueNode<T> next;
        
        public QueueNode(T item) {
            this.data = item;
        }
    }
    
    private QueueNode<T> first;
    private QueueNode<T> last;
    
    public void add(T item) {       
        QueueNode<T> t = new QueueNode(item);
        if(last != null) {
            last.next = t;
        }
        last = t;
        if(first == null) first = last;
        
    }
    
    public T remove() {
        if(first == null) throw new NoSuchElementException();
        T value = first.data;
        first = first.next;
        if(first == null) {
            last = null;
        }
        return value;
        
    }
    
    public T peek() {
        if(first == null) throw new NoSuchElementException();
        return first.data;
    }
    
    public boolean isEmpty() {
        return first == null;
    }
}
