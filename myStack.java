import java.util.EmptyStackException;

public class myStack<T> {
    
    private class StackNode<T> {
        private T data;
        private StackNode<T> next;
        
        public StackNode(T item) {
            this.data = item;
        
        }
    }
        
        StackNode<T> top;
        
        public T pop() {
            if(top == null) return (T) new EmptyStackException();
            T val = top.data;
            top = top.next;
            return val;
        }
        
        public void push(T item) {
            StackNode<T> newItem = new StackNode(item);
            newItem.next = top;
            top = newItem;
        }
        
        public T peek() {
            if(top == null) return (T) new EmptyStackException();
            return top.data;
        }
        
        public boolean isEmpty() {
            return (top == null);
        }
    
    
        public static void main(String[] args) {
            myStack stack = new myStack();
        
            System.out.println(stack.peek());
            stack.push(3);
            System.out.println(stack.peek());
            stack.push(4);
            printStack(stack);
            System.out.println(stack.peek());

    
        }
        
        public static void printStack(myStack stack) {
            
            while(!stack.isEmpty()) {
                System.out.print(stack.pop() + " ");
            }
            System.out.println();
        }

}
