package Utils;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;

/**
 * @author krystian
 */
public class CustomHashSet<T> extends LinkedHashSet<T> {

    public T get(int index) {
        Iterator iterator = this.iterator();
        T elementAtIndex = null;
        if (index >= this.size() || index < 0){
            throw new ArrayIndexOutOfBoundsException();
        }
        int i = 0;
        while (iterator.hasNext() && i <= index) {
            elementAtIndex = (T) iterator.next();
            i++;
        }
        return elementAtIndex;
    }

}
