public class ArrayStack<T> implements Stack {
    private T arr[];
    private int peek;
    private int itemCount;
    
    // constructor
    public ArrayStack() {
        arr = (T[]) new Object[10];
        peek = 0;
        itemCount = 10;
    }

    @Override
    public void push(Object item) {
        if(peek == itemCount) { // growing the array
            T[] temp;
            temp = (T[]) new Object[itemCount * 2];
            for(int i=0; i<itemCount; i++) {
                temp[i] = arr[i];
            }
            arr = temp;
            itemCount = itemCount*2;

        }
        arr[peek] = (T) item; // adding the item at the end
        peek++;

    }

    @Override
    public Object pop() {
        Object rmv = arr[peek-1];
        arr[peek-1] = null;
        peek--;
        return rmv; // returning the removed item
    }

    @Override
    public Object peek() {
        if(peek < 0) {
            return null;
        }
        return arr[peek]; // return the top item
    }

    @Override
    public boolean empty() {
        return peek == 0;
    }
}
