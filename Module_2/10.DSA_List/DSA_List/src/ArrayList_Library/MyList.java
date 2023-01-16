package ArrayList_Library;

public class MyList<E> {
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private Object emelements[];

    public MyList() {
    }

    public MyList(int capacity) {
        this.size = capacity;
    }
    public void add (int index, E e){
        ensureCapacity();
        for (int i = size - 1; i >= index; i--) emelements[i + 1] = emelements[i];
        emelements[index] = e;
        size++;
    }

    public void clear() {
        emelements = (E[]) new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    public boolean contains(E e) {
        for (int i = 0; i < size; i++)
            if (emelements[i].equals(e))// thử đổi chỗ e và emelements
                return true;
        return false;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException
                    ("index " + index + " out of bounds");
    }

    public int get(int index) {
        if (index>= size || index <0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size " + index );
        }
        return (int) emelements[index];
    }

    public int indexOf(E e) {
        for (int i = 0; i < size; i++)
            if (e.equals(emelements[i])) return i; // thử đổi chỗ e và emelements
        return -1;
    }

    public E remove(int index) {
        checkIndex(index);

        E e = (E) emelements[index];

        // Shift data to the left
        for (int j = index; j < size - 1; j++)
            emelements[j] = emelements[j + 1];

        emelements[size - 1] = null; // This element is now null

        // Decrement size
        size--;
        return e;
    }

        //int size

        //E clone

        //boolean add

        private void ensureCapacity() {
            if (size >= emelements.length) {
                E[] newData = (E[]) (new Object[size * 2 + 1]);
                System.arraycopy(emelements, 0, newData, 0, size);
                emelements = newData;
            }
        }

        public void set(int index, E e){
            emelements[index] = e;
        }

        public int size(){
            return size;
        }

        public boolean isEmpty(){
            if (size == 0) {
                return true;
            } else {
                return false;
            }
        }

        public int lastIndexOf(E e){
            int a = 0;
            for (int i = 0 ; i < size; i++) {
                if (emelements[i] == e){
                    a = i;
                } else {
                    a = -1;
                }
            }
            return a;
        }

}
