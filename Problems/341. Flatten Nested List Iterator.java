/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
    public List<Integer> outputList = new ArrayList();
    int currentIndex = -1;
    int nextIndex;
    public NestedIterator(List<NestedInteger> nestedList) {
        addToIntegerList(nestedList);
    }

    @Override
    public Integer next() {
        currentIndex = nextIndex;
        return outputList.get(currentIndex);
    }

    @Override
    public boolean hasNext() {
        nextIndex = currentIndex + 1;
        if(nextIndex < outputList.size()){
            return true;
        }
        else{
            return false;
        }
            
    }
    public void addToIntegerList(List<NestedInteger> list){
        for(NestedInteger n: list){
            if(n.isInteger()){
                outputList.add(n.getInteger());
            }
            else{
                List<NestedInteger> next = n.getList();
                if(next.size()>0)
                    addToIntegerList(next);
            }
        }
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
