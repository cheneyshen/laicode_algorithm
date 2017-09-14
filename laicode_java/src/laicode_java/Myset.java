package laicode_java;
import java.util.*;

public class Myset {
	
	private int[] set;
	private int size;
	private int capacity;
	
	public Myset(int c) {
		this.capacity=c;
		this.set=new int[c];
		this.size=0;
	}
	
	public boolean contains(int x) {
		boolean contains=false;
		for (int i=0; i<capacity; i++) {
			if (x==set[i]) {
				contains=true;
				break;
			}
		}
		return contains;
	}
	
	public void add(int x) {
	    if (contains(x))
	        return;
	    if (size >= capacity) {
	        capacity *= 2;
	        set = Arrays.copyOf(set, capacity);
	    }
	    set[size++] = x;
	}
	
	public boolean remove(int x) {
		boolean remove=false;
		for(int i=0; i<capacity; i++) {
			if(x==set[i]) {
				set[i]=set[size-1];
				size--;
				remove=true;
			}
			if(isEmpty()) {
				remove=false;
			}
		}
		return remove;
	}
	
	public void clear() {
		set=null;
		size=0;
	}
	public int size() {
		return size;
	}
	public boolean isEmpty() {
		if(size==0) {
			return true;
		}
		else {
			return false;
		}
	}
	public int[] toArray() {
		return Arrays.copyOf(set, capacity);
	}
}
