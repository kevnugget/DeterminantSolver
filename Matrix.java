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

    public static Matrix of(int[][] values) {
        return new Matrix(values);
    }

    public int findDeterminant()
    {
        if (length != width) {
            throw new IllegalArgumentException("Matrix must be a square (n x n) matrix.");
        }
        if (length == 1)
        {
            return matrix[0][0];
        }
        if (length == 2)
        {
            return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
        }
        else {
            int det = 0;
            for (int col = 0; col < width; col++) {
                det += matrix[0][col]*Math.pow(-1, (col))*findMinor(matrix, 0, col).findDeterminant(); // using co-factor expansion
            }
            return det;
        }
    }

    public Matrix findMinor(int[][] inputMatrix, int row, int col)
    {
        int[][] minor = new int[length - 1][width - 1];
        int r = 0, c = 0;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                if (i != row && j != col)
                {
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
}
