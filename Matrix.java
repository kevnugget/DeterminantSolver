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
            return this.matrix[0][0];
        }
        if (length == 2) {
            int det = this.matrix[0][0] * this.matrix[1][1] - this.matrix[0][1] * this.matrix[1][0];
            return det;
        }
        else {
            int det = 0;
            for (int col = 0; col < width; col++) {
                det += matrix[0][col]*Math.pow(-1, (col))*findMinor(this, 0, col); // calculates using co-factor expansion of first row
            }
            return det;
        }
    }

    public int findMinor(Matrix inputMatrix, int row, int col) // finding the ith and jth minor of the matrix
    {
        if (inputMatrix == null || inputMatrix.length != inputMatrix.width) {
            throw new IllegalArgumentException("Input matrix must be a square matrix.");
        }

        if (row > length || col > width || row < 0 || col < 0 || length == 1 || width == 1)
        {
            throw new IllegalArgumentException("Invalid Row or Column.");
        }


        int[][] minor = new int[length - 1][width - 1];
        int r = 0, c = 0;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                if (i != row && j != col) {
                    minor[r][c++] = inputMatrix.matrix[i][j];
                    if (c == width - 1) {
                        c = 0;
                        r++;
                    }
                }
            }
        }
        return Matrix.of(minor).findDeterminant();
    }

    public String toString() { // formatting matrix
        StringBuilder matrixString = new StringBuilder();
        for (int i = 0; i < length; i++) {
            matrixString.append("|\t");
            for (int j = 0; j < width; j++) {
                matrixString.append(matrix[i][j]).append("\t");
            }
            matrixString.append("|\n");
        }
        return matrixString.toString();
    }
}
