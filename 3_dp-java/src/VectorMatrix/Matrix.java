package VectorMatrix;
import java.util.Arrays;

/*
 * Author: Mattia
 * Date: 11.01.23
 * 
 * In this class a framework is provided to work with matrices.
 */


public class Matrix {
	public Dimension dimension;
	public int[][] data;
	
	/* CONSTRUCTORS */
	public Matrix(int[][] data) {
		for (int i = 0; i < data.length - 1; i++) {
			if (data[i].length != data[i+1].length)
				throw new IllegalArgumentException("Faulty format of passed 2d array");
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
			throw new IllegalArgumentException("Dimension of matrix and vector not matching");
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
			throw new IllegalArgumentException("Dimensions of matrices not matching");
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
	public Matrix strassenMultiply(Matrix other) {		
		if (this.dimension.rows == 1 && this.dimension.cols == 1)
			return other.multiply(this.data[0][0]);
		if (other.dimension.rows == 1 && other.dimension.cols == 1)
			return this.multiply(other.data[0][0]);
		
		if (this.dimension.rows != this.dimension.cols ||
				other.dimension.rows != other.dimension.cols ||
				this.dimension.cols != other.dimension.rows ||
				(this.dimension.rows & this.dimension.rows-1) != 0)
			throw new IllegalArgumentException("Faulty matrices passed: same dimension and n = 2^k required");
		
		// submatrices
		Matrix a = other.getSubmatrixEx(0, other.dimension.rows/2, 0, other.dimension.cols/2);
		Matrix b = other.getSubmatrixEx(0, other.dimension.rows/2, other.dimension.cols/2, other.dimension.cols);
		Matrix c = other.getSubmatrixEx(other.dimension.rows/2, other.dimension.rows, 0, other.dimension.cols/2);
		Matrix d = other.getSubmatrixEx(other.dimension.rows/2, other.dimension.rows, other.dimension.cols/2, other.dimension.cols);
		
		Matrix e = this.getSubmatrixEx(0, this.dimension.rows/2, 0, this.dimension.cols/2);
		Matrix f = this.getSubmatrixEx(0, this.dimension.rows/2, this.dimension.cols/2, this.dimension.cols);
		Matrix g = this.getSubmatrixEx(this.dimension.rows/2, this.dimension.rows, 0, this.dimension.cols/2);
		Matrix h = this.getSubmatrixEx(this.dimension.rows/2, this.dimension.rows, this.dimension.cols/2, this.dimension.cols);
		
		// seven multiplications
		Matrix product1 = (f.subtract(h)).strassenMultiply(c.add(d));
		Matrix product2 = (e.subtract(g)).strassenMultiply(a.add(b));
		Matrix product3 = (e.add(h)).strassenMultiply(a.add(d));
		Matrix product4 = (e.add(f)).strassenMultiply(d);
		Matrix product5 = (g.add(h)).strassenMultiply(a);
		Matrix product6 = e.strassenMultiply(b.subtract(d));
		Matrix product7 = h.strassenMultiply(c.subtract(a));
		
		Matrix product = mergeSubmatrices(
				product1.add(product3).add(product7).subtract(product4),
				product4.add(product6),
				product5.add(product7),
				product3.add(product6).subtract(product2).subtract(product5));
		
		return product;
	}	
	public Matrix add(Matrix other) {
		if (this.dimension.cols != other.dimension.cols ||
				this.dimension.rows != other.dimension.cols)
			throw new IllegalArgumentException("Dimensions of matrices not matching");
		int[][] newData = new int[this.dimension.rows][this.dimension.cols];
		for (int i = 0; i < this.dimension.rows; i++) {
			for (int j = 0; j < this.dimension.cols; j++)
				newData[i][j] = this.data[i][j] + other.data[i][j];
		}
		return new Matrix(newData);
	}
	public Matrix subtract(Matrix other) {
		return add(other.multiply(-1));
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
	public Matrix getSubmatrixEx(
			int rowStart,
			int rowEnd,
			int colStart,
			int colEnd) {
		int[][] cutRows = Arrays.copyOfRange(data, rowStart, rowEnd);
		int[][] newData = new int[rowEnd - rowStart][colEnd - colStart];
		for (int i = 0; i < cutRows.length; i++) {
			newData[i] = Arrays.copyOfRange(cutRows[i], colStart, colEnd);
		}
		return new Matrix(newData);
	}
	public static Matrix mergeSubmatrices(
			Matrix topLeftMatrix,
			Matrix topRightMatrix,
			Matrix bottomLeftMatrix,
			Matrix bottomRightMatrix) {
		// if any of the dimensions don't match, throw Exception
		if (topLeftMatrix.dimension.rows != topRightMatrix.dimension.rows ||
				bottomLeftMatrix.dimension.rows != bottomRightMatrix.dimension.rows ||
				topLeftMatrix.dimension.cols != bottomLeftMatrix.dimension.cols ||
				topRightMatrix.dimension.cols != bottomRightMatrix.dimension.cols)
			throw new IllegalArgumentException("Dimensions of submatrices not matching");
		int[][] newData = new int[topLeftMatrix.dimension.rows + bottomLeftMatrix.dimension.rows][topLeftMatrix.dimension.cols + topRightMatrix.dimension.cols];
		for (int i = 0; i < topLeftMatrix.dimension.rows; i++) {
			for (int j = 0; j < topLeftMatrix.dimension.cols; j++)
				newData[i][j] = topLeftMatrix.data[i][j];
			for (int j = 0; j < topRightMatrix.dimension.cols; j++)
				newData[i][topLeftMatrix.dimension.cols + j] = topRightMatrix.data[i][j];
		}
		for (int i = 0; i < bottomLeftMatrix.dimension.rows; i++) {
			for (int j = 0; j < bottomLeftMatrix.dimension.cols; j++)
				newData[topLeftMatrix.dimension.rows + i][j] = bottomLeftMatrix.data[i][j];
			for (int j = 0; j < bottomRightMatrix.dimension.cols; j++)
				newData[topLeftMatrix.dimension.rows + i][topLeftMatrix.dimension.cols + j] = bottomRightMatrix.data[i][j];
		}
		return new Matrix(newData);
	}
}
