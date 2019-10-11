public class ArrayQueue<T> implements Queue<T>
{
    private T[] a = (T[]) new Object[10];
    private int front = 0;
    private int back = 0;

    // takes an item out of the queue from the front (first in first out algorithm)
    public T dequeue(){
        T item = a[front];
        front = (front+1) % a.length;
        return item;
    }

    // adds an item to the queue at the back
    /* if the array is already full, that is, if the
       new position goes one position past the front
       wherever that may be in the array, then grow the array
    */
    public void enqueue(T item){
        if((back+1) % a.length == front){
            grow_array();
        }
        a[back++] = item;
        back = back % a.length;
    }

    // the queue is empty if the front is the same index as the back
    public boolean empty(){
        return (front == back);
    }

    // grows the array to twice the size of the previous
    /*
       if the index of the front is less than the index of the back,
       or in other words, if the font and back are in logical order,
       then copy the items from front to back
    */
    /*
       if the front is more than the back, if the queue circled around
       in the array, then the values of the array need to be copied in two separate parts,
       from front to the end of the array and then from the start of the array to the back
     */
    // the front and back are then reset so that they have the same values as before
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
