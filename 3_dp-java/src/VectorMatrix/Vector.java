package VectorMatrix;

/*
 * Author: Mattia
 * Date: 11.01.23
 * 
 * In this class a framework is provided to work with vectors.
 */

public class Vector {
	Dimension dimension;
	int[] data;
	
	/* CONSTRUCTORS */
	public Vector(int[] data) {
		dimension = new Dimension(data.length, 1);
		this.data = data;
	}
	
	/* HELPER METHODS */
	public String toString() {
		String returnString = " " + dimension.rows + " x " + dimension.cols + "\n[";
		for (int i = 0; i < dimension.rows; i++)
			returnString += ((i == 0)? "": " ") + data[i] + ((i == dimension.rows - 1)? "": "\n");
		return returnString + "]\n";
	}
}