package PackageCuz;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

class Bag<T> implements Iterable<T> {
	
	/*
	 * Bag class that implements the Iterable method to get through the array. 
	 * add method was the most simple and has been used a lot in previous assignments
	 * 
	 * Working with the Iterator method was at first hard to get what was going on
	 * except that it was moving through the array. I did come to understand each part
	 * I used it to work with all of the methods that I have to modify the Bag. It also
	 * made the code really nice and clean. 
	 */
    private ArrayList<T> items = new ArrayList<>();

    public void add(T item) {
        items.add(item);
    }

    public void remove(T item) {
    	Iterator<T> one = items.iterator();
    	while(one.hasNext()) {
    		if(one.next().equals(item)) {
    			one.remove();
    			return;
    		}
    	}
    }

    public boolean contains(T item) {
    	Iterator<T> contain = items.iterator();
    	while(contain.hasNext()) {
    		if(contain.next().equals(item)) {
    			return true;
    		}
    	}
    	return false;
    }
    
    public void clear() {
    	items.clear();
    }
    
    
    public int count(T item) {
    	int count = 0;
    	Iterator<T> counter = items.iterator();
    	while(counter.hasNext()) {
    		if(counter.next().equals(item)) {
    			count++;
    		}
    	}
    	return count;
    }
    
    /*
     * Added Size, merge and distinct methods
     * 
     * Also added toString to be able to print out the contents of the bags
     * 
     * Iteration is "simple" yet suddenly complex. I have found now 3 ways to iterate
     * through an array. 2 of them are here: "distinct" and the ones above. There is
     * another way where you use a loop (i = 0; i < array.lenght; i++) or something along
     * these lines. For consistency, I tried to keep them as much similar as possible. 
     * 
     * I also seem to understand that a "Set" as it states in our course work, cannot
     * take duplicates. This seems to actually be "forces". Below when I created a "Set"
     * it only allowed unique items, so when I transfered them to the "distinctBag" 
     * there were not duplicates. This seems a way to eliminate duplicates if wanted. 
     */
    
    public void merge(Bag<T> otherItems) {
    	for(T item : otherItems.items) {
    		this.items.add(item);
    	}
    }
    
    public int size() {
    	return items.size();
    }
    
    public Bag<T> distinct() {
    	Bag<T> distinctBag = new Bag<>();
    	Set<T> uniqueItems = new HashSet<>(items);
    	for(T item : uniqueItems) {
    		distinctBag.add(item);
    	}
    	return distinctBag;
    }
    public void print() {	
		for(Object item : items) {
			System.out.print(item + " ");	
		}
    }
	
    @Override
    public Iterator<T> iterator() {
        return items.iterator();
    }
    
    @Override
    public String toString() {
    	return items.toString();
    }
}