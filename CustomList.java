import java.util.Collection;
import java.util.AbstractList;
import java.lang.IllegalArgumentException;
import java.lang.IndexOutOfBoundsException;

public class CustomList<E> extends AbstractList<E> {
    public static int DEFAULT_SIZE = 10;

    private int size = 0;
    private E[] data;

    public CustomList(int capacity) {
        if (capacity < 0)
            throw new IllegalArgumentException();
        data = (E[]) new Object[capacity];
    }

    public CustomList() {
        this(DEFAULT_SIZE);
    }

    public CustomList(Collection<? extends E> c) {
        this((int) c.size());
        for (Object o : c) {
            data[size++] = (E) o;
        }
    }

    public void ensureCapacity(int min) {
        int current = data.length;
        if (min > current) {
            E[] newData = (E[]) new Object[Math.max(current * 2, min)];
            System.arraycopy(data, 0, newData, 0, size);
            data = newData;
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E get(int index) {
        if (index < 0 || index > size - 1)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        return data[index];
    }

    public boolean add(E x) {
        if (size == data.length)
            ensureCapacity(size + 1);
        data[size++] = x;
        return true;
    }

    public boolean remove(Object o) {
        return super.remove(o);
    }

    public E remove(int index) {
        return super.remove(index);
    }

    public void printList() {
        for (int i = 0; i < size; i++)
            System.out.print(data[i] + " ");
        System.out.println();
    }
}