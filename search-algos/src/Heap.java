import java.util.ArrayList;

public class Heap<T extends Comparable<? super T>>{
	ArrayList<T> H;
	boolean min;
	
	public Heap(T[] elements, boolean min) {
		H = new ArrayList<T>();
		for (T element : elements)
			H.add(element);
		this.min = min;
		for (int i = 0; i < this.H.size()/2; i++)
			restoreHeapCondition();
	}
	
	public void restoreHeapCondition() {
		for (int j = 0; j < H.size();) {
			if (j*2 < this.H.size() && 0 <= this.H.get(2*j+1).compareTo(this.H.get(2*j+2)) && 0 <= this.H.get(2*j+1).compareTo(this.H.get(j))) {
				swap(j, j*2 + 1);
				j = 2*j + 1;
			} else if ((j+1)*2 < this.H.size() && 0 < this.H.get((j+1)*2).compareTo(this.H.get(2*j+1)) && 0 < this.H.get((j+1)*2).compareTo(this.H.get(j)) ) {
				swap(j, (j+1)*2);
				j = (j+1)*2;
			} else
				break;
		}
	}
	
	public void swap(int i, int j) {
		T temp = H.get(i);
		H.set(i, H.get(j));
		H.set(j, temp);
	}
}
