package frompythontojava.onlineshop;

import java.util.ArrayList;

public interface Iterator {
    Iterator getIterator();
    public boolean hasNext(ArrayList list);
    public Object next(ArrayList list);
}
