public class ArrayQueue<T> implements Queue<T>
{
    private T[] a = (T[]) new Object[10];
    private int front = 0;
    private int back = 0;

    public T dequeue(){
        T item = a[front];
        front = (front+1) % a.length;
        return item;
    }

    public void enqueue(T item){
        if((back+1) % a.length == front){
            grow_array();
        }
        a[back++] = item;
        back = back % a.length;
    }

    public boolean empty(){
        return (front == back);
    }

    private void grow_array(){
        int newSize = a.length*2;
        T[] new_a = (T[]) new Object[newSize];
        if(front < back){
            System.arraycopy(a, front, new_a, 0, a.length-front);
        } else {
            System.arraycopy(a, front, new_a, 0, a.length-front);
            System.arraycopy(a, 0, new_a, a.length - front, back);
        }
        front = 0;
        back = a.length-1;
        a = new_a;
    }
}
