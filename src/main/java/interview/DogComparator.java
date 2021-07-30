package interview;

import java.util.Comparator;

/**
 * Created by ima on 27/11/18.
 */
public class DogComparator implements Comparator{

    @Override
    public int compare(Object o1, Object o2) {
        int result = ((Dog)o1).getName().compareToIgnoreCase(((Dog)o2).getName());
        if(result == 0) {
            result = ((Dog)o1).getAge().compareTo(((Dog)o2).getAge());
        }
        return result;
    }
}
