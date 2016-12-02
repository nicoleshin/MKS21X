//import java.util.Iterator;
public class SuperArray implements Iterable<String>{
    private String[] data;
    private int realSize;
    private int size;
    public SuperArray() {
        data = new String[10];
        size = 0;
        realSize = 10;
    }

    public SuperArray(int initialCapacity) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException();
        }
        data = new String[initialCapacity];
        size = 0;
        realSize = initialCapacity;
    }


    private void grow() {
        String[] fin = new String[realSize*realSize];
        for (int i = 0; i < size; i++) {
            fin[i] = data[i];
        }
        data = fin;
        realSize = size*2;
    }

    public boolean add(String value) {
        if (size+1 > realSize) {
            grow();
        }
        data[size] = value;
        size+=1;
        return true;
    }

    public String get(int index) {
        if (index < 0 || index>=size) {
            throw new IndexOutOfBoundsException();
        }
        return data[index];
    }

    public int size() {
        return size;
   }

   public String toString() {
        String fin = "[";
        for (int i = 0; i<size; i++) {
            fin = fin+data[i]+",";
        }
        return fin.substring(0, fin.length()-1) + "]";
   }

    public String toStringDebug() {
        String fin = toString();
        fin = fin.substring(0, fin.length()-1) + ",";
        for (int i = size; i < realSize; i++) {
            fin += "_"+",";
        }
        return fin.substring(0, fin.length()-1) + "]";
    }

    public void clear() {
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public String set(int index, String value) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        String ret = data[index];
        data[index] = value;
        return ret;
    }

    private void shift(int index, String value) {
        for (int i = size-1; i>index-1; i-=1) {
            data[i+1] = data[i];
        }
        data[index] = value;
    }

    public void add(int index, String value) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if (size+1 > realSize) {
            grow();
        }
        shift(index,value);
        size+=1;
    }

    public String remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        String ret = data[index];
        for (int i = index; i < size; i++) {
            data[i] = data[i+1];
        }
        data[size-1] = "";
        size-=1;
        return ret;
    }

    public String[] toArray() {
        String[] ary = new String[size];
        for (int i = 0; i < size; i++) {
            ary[i] = data[i];
        }
        return ary;
    }

    public int indexOf(String ele) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(ele)) {
                return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(String ele) {
        for (int i = size-1; i > -1; i-=1) {
            if (data[i].equals(ele)) {
                return i;
            }
        }
        return -1;
    }

    public void trimToSize() {
        data = toArray();
        realSize = size;
    }
}
