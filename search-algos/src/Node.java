
public class Node<T extends Comparable<T>> implements Comparable<Node<T>>{
	T value;
	
	public Node(T value) {
		this.value = value;
	}
	
	@Override
	public int compareTo(Node<T> other) {
		return ((T) this.value).compareTo((T) other.value);
	}
}
