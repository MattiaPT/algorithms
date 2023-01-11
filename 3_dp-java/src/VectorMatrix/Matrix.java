package VectorMatrix;

/*
 * Author: Mattia
 * Date: 11.01.23
 * 
 * In this class a framework is provided to work with matrices.
 */


public class Matrix {
	Dimension dimension;
	int[][] data;
	
	/* CONSTRUCTORS */
	public Matrix(int[][] data) {
		for (int i = 0; i < data.length - 1; i++) {
			if (data[i].length != data[i+1].length)
				throw new IllegalArgumentException();
		}
		dimension = new Dimension(
				data.length,
				(data.length == 0)? 0: data[0].length
		);
		this.data = data;
	}
	
	public Matrix multiply(int scalar) {
		int[][] newData = new int[dimension.rows][dimension.cols];
		for (int i = 0; i < dimension.rows; i++) {
			for (int j = 0; j < dimension.cols; j++)
				newData[i][j] = scalar * data[i][j];
		}
		return new Matrix(newData);
	}
	
	public Vector multiply(Vector vector) {
		if (this.dimension.cols != vector.dimension.rows)
			throw new IllegalArgumentException();
		int[] newData = new int[this.dimension.rows];
		for (int i = 0; i < this.dimension.rows; i++) {
			int sum = 0;
			for (int j = 0; j < this.dimension.cols; j++)
				sum += data[i][j] * vector.data[j];
			newData[i] = sum;
		}
		return new Vector(newData);
	}
	public Matrix multiply(Matrix other) {
		if (this.dimension.cols != other.dimension.rows)
			throw new IllegalArgumentException();
		int[][] newData = new int[this.dimension.rows][other.dimension.cols];
		for (int i = 0; i < this.dimension.rows; i++) {
			for (int j = 0; j < other.dimension.cols; j++) {
				int sum = 0;
				for (int k = 0; k < this.dimension.cols; k++)
					sum += this.data[i][k] * other.data[k][j];
				newData[i][j] = sum;
			}
		}
		return new Matrix(newData);
	}
	
	/* HELPER METHODS */
	public String toString() {
		String returnString = " " + dimension.rows + " x " + dimension.cols + "\n[";
		for (int i = 0; i < dimension.rows; i++) {
			returnString += ((i == 0)? "": " ") + "[";
			for (int j = 0; j < dimension.cols; j++) {
				returnString += data[i][j] + ((j == dimension.cols - 1)? "": " ");
			}
			returnString+= "]" + ((i == dimension.rows - 1)? "": "\n");
		}
		return returnString + "]\n";
	}
}
