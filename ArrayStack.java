public class ArrayStack<T> implements Stack<T>
{
    private T[] a = (T[]) new Object[10];
    private int top = -1;

    public void push(T item){
        if(a.length-1 == top){
            grow_array();
        }
        a[++top] = item;
    }

    public T pop(){
        return a[top--];
    }

    public T peek(){
        return a[top];
    }

    public boolean empty(){
        return (top==-1);
    }

    private void grow_array(){
        int newSize = a.length*2;
        T[] new_a = (T[]) new Object[newSize];
        System.arraycopy(a, 0, new_a, 0, a.length);
        a = new_a;
    }
}
