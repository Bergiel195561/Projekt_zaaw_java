package Utils;

import java.util.HashSet;
import java.util.Iterator;

/**
 * @author krystian
 */
public class CustomHashSet<T> extends HashSet<T> {

    public T get(int index) throws ArrayIndexOutOfBoundsException {
        Iterator iterator = this.iterator();
        T elementAtIndex = null;
        int i = 0;
        while (iterator.hasNext() && i <= index) {
            elementAtIndex = (T) iterator.next();
        }
        if (elementAtIndex == null){
            throw new ArrayIndexOutOfBoundsException();
        }
        return elementAtIndex;
    }

}
