
public class Node<T extends Comparable<T>> implements Comparable<Node<T>>{
	static int id;
	
	int index;
	T value;
	
	public Node(T value) {
		this.index = id++;
		this.value = value;
	}
	
	@Override
	public int compareTo(Node<T> other) {
		return ((T) this.value).compareTo((T) other.value);
	}
	
	public String toString() {
		return "index: " + index + "\tvalue: " + value;
	}
}
