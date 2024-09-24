public class determinantTester
{
    public static void main(String[] args) {
        /*  To run this on your own, creating a new Matrix requires the following syntax:

        Matrix nameOfMatrix = Matrix.of(new int[][] {{value}, {value}, {value}});
        Each corresponding {} increases the row count of the 2D array, so clients can enter any size of their desired matrix.

        */
        // Sample Tests
        Matrix m1 = Matrix.of(new int[][] {{3, 4},{5, 7}}); 
        Matrix m2 = Matrix.of(new int[][] {{3, 4, 8},{5, 7, -9}, {9, 3, 5}}); 
        Matrix m3 = Matrix.of(new int[][] {{1, 566, 321}, {32, 4565}});
        System.out.println(m1.findDeterminant()); // Determinant = 1
        System.out.println(m2.findDeterminant()); // Determinant = -622
        System.out.println(m3.findDeterminant()); // should throw Error
    }
}