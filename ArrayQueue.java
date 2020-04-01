public class ArrayQueue<T> implements Queue {
    int size;
    T arr[];
    int head;
    int tail;

    // constructor
    public ArrayQueue() {
        arr = (T[]) new Object[10];
        head = 0;
        tail = 0;
        size = 10;
    }

    @Override
    public Object dequeue() throws Exception {
        T deq;
        if (head == tail){
            throw new Exception("Queue is empty");
        }
        deq = arr[head]; // return the head value
        head++;
        return deq;
    }

    @Override
    public void enqueue(Object item) {
        if (tail == size) {
            T temp[];
            temp = (T[]) new Object[size * 2]; // growing array
            if (size >= 0) System.arraycopy(arr, 0, temp, 0, size);
            arr = temp;
            size = size*2;
        }
        arr[tail] = (T)item; // add the item at the end of queue
        tail++;
    }

    @Override
    public boolean empty() {
        return head == tail;
    }
}
