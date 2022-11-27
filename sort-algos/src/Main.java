class Main {
    public static void main(String[] args) {
	Sorter s = new Sorter();
	System.out.println(s.list);
	s.list = new int[] {1, 3, 3};
	System.out.println(s.isSorted());
    }
}
