package pair2;

import pair1.Pair;

import java.lang.reflect.Array;
import java.time.*;

/**
 * This program demonstrates how to create a generic method.
 * @author Stone
 */

public class PairTest2 {
    public static void main(String[] args) {
        LocalDate[] birthday = {
                LocalDate.of(1906, 12, 9),
                LocalDate.of(1903, 12, 3)
        };
        Pair<LocalDate> mm =ArrayAlg.minmax(birthday);
        System.out.println("min = " + mm.getFirst());
        System.out.println("max = " + mm.getSecond());
    }
}

class ArrayAlg {
    public static <T extends Comparable> Pair<T> minmax(T[] a) {
        if (a == null || a.length == 0) return null;
        T min = a[0];
        T max = a[0];
        for(int i = 0; i < a.length; i++) {
            if(min.compareTo(a[i]) > 0) min = a[i];
            if(max.compareTo(a[i]) < 0) max = a[i];
        }

        return new Pair<>(min, max);
    }
}
