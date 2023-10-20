import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class NestedIterator implements Iterator<Integer> {
    private List<Integer> storage = new ArrayList<>();
    private List<NestedInteger> nestedList;
    private int currentIndex = -1;

    public NestedIterator(List<NestedInteger> nestedList) {
        this.nestedList = nestedList;
        if(!nestedList.isEmpty()) {
            flatRecursively(this.nestedList, 0);
        }
    }
    public void flatRecursively(List<NestedInteger> nestedList, int index){
        if(index == nestedList.size()){
            return;
        }
        if(nestedList.get(index).isInteger()){
            storage.add(nestedList.get(index).getInteger());
            flatRecursively(nestedList, index + 1);
        }
        if(!nestedList.get(index).isInteger()){
            flatRecursively(nestedList.get(index).getList(), 0);
            flatRecursively(nestedList, index + 1);
        }
    }
    @Override
    public Integer next() {
       return storage.get(currentIndex);
    }

    @Override
    public boolean hasNext() {
        return ++currentIndex < storage.size();

    }
}

