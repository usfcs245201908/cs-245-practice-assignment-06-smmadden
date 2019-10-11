public class ArrayStack<T> implements Stack<T>
{
    private T[] a = (T[]) new Object[10];
    private int top = -1;                   // keeps track of the item last added to the stack

    // adds an item to the stack
    // if the stack is full, then we need to grow the array to accommodate another item
    public void push(T item){
        if(a.length-1 == top){
            grow_array();
        }
        a[++top] = item;
    }

    // returns the item on the top of the stack (first in last out algorithm)
    public T pop(){
        return a[top--];
    }

    // program can look at what the item at the top of the stack is
    public T peek(){
        return a[top];
    }

    // if the index for the top of the array is -1, that means that the stack is completely empty
    public boolean empty(){
        return (top==-1);
    }

    // doubles the size of the array by creating a new array
    // and copying every item into the new array
    private void grow_array(){
        int newSize = a.length*2;
        T[] new_a = (T[]) new Object[newSize];
        System.arraycopy(a, 0, new_a, 0, a.length);
        a = new_a;
    }
}
