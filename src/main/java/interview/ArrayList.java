package interview;

import java.lang.reflect.Array;

public class ArrayList<T> {
    private T[] array;
    ArrayList(int defaultSize, Class<T> t) {
        array = (T[]) Array.newInstance(t, defaultSize);
    }

    public T[] getArray() {
        return array;
    }

    public void setArray(T[] array) {
        this.array = array;
    }

    public boolean add(T t) {
        if(array[array.length -1] != null) {
            T[] temp = (T[]) Array.newInstance(t.getClass(), array.length * 2);
            int i=0;
            while(i < array.length) {
                temp[i] = array[i];
                i++;
            }
            temp[i] = t;
            setArray(temp);
            return true;
        } else {
            for(int i=0; i< array.length; i++) {
                if(array[i] == null) {
                    array[i] = t;
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ArrayList<String> resizableArray = new ArrayList<String>(2, String.class);
        resizableArray.add("abc");
        resizableArray.add("def");
        resizableArray.add("ghi");
        resizableArray.add("jkl");

        for(String s: resizableArray.getArray()) {
            System.out.println(s);
        }
    }
}

