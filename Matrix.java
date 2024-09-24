public class Matrix {
    private int[][] matrix;
    private int length, width;

    public Matrix(int[][] matrix)
    {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) { // invalid matrix
            throw new IllegalArgumentException("Matrix cannot be null or empty.");
        }
        this.length = matrix.length;
        this.width = matrix[0].length;
        this.matrix = matrix;
    }

    public static Matrix of(int[][] values) { // creates the Matrix object syntax
        return new Matrix(values);
    }

    public int findDeterminant()
    {
        if (length != width) {
            throw new IllegalArgumentException("Matrix must be a square (n x n) matrix."); // undefined matrix for determinant
        }
        if (length == 1) {
            return matrix[0][0];
        }
        if (length == 2) {
            int det = matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0]; 
            {
                if (det == 0) {
                    throw new Error("Error: Determinant cannot be 0.");
                }
            }
            return det;
        }
        else {
            int det = 0;
            for (int col = 0; col < width; col++) {
                det += matrix[0][col]*Math.pow(-1, (col))*findMinor(matrix, 0, col).findDeterminant(); // calculates using co-factor expansion of row 1
            }
            return det;
        }
    }

    public Matrix findMinor(int[][] inputMatrix, int row, int col) // finding the ith and jth minor of the matrix
    {
        int[][] minor = new int[length - 1][width - 1];
        int r = 0, c = 0;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                if (i != row && j != col) {
                    minor[r][c++] = inputMatrix[i][j];
                    if (c == width - 1) {
                        c = 0;
                        r++;
                    }
                }
            }
        }
        return Matrix.of(minor);
    }

    public String toString() { // formatting matrix
        String matrixString = "";
        for (int i = 0; i < length; i++) {
            matrixString += "|\t";
            for (int j = 0; j < width; j++)
            {
                matrixString += matrix[i][j] + "\t";
            }
            matrixString += "|\n";
        }

        return matrixString;
    }
}
