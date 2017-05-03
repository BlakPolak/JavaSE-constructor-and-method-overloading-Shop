package frompythontojava.onlineshop;
import java.util.ArrayList;

public class ProductIterator implements Iterator {
    private Integer index = 0;

    public ProductIterator(){

    }

    @Override
    public Iterator getIterator() {
        return new ProductIterator();
    }

    @Override
    public boolean hasNext(ArrayList list) {
        if(index < list.size() && list.get(index) != null){
            return true;
        }
        return false;
    }

    @Override
    public Object next(ArrayList list) {
        return list.get(index++);
    }

}
