public class determinantTester
{
    public static void main(String[] args) {
        /*  To run this on your own, creating a new Matrix requires the following syntax:

        Matrix nameOfMatrix = Matrix.of(new int[][] {{value}, {value}, {value}});
        Each corresponding {} increases the row count of the 2D array, so you can enter any size of your desired matrix.

        */
        // Sample Tests; feel free to remove
        Matrix m1 = Matrix.of(new int[][] {{3, 4},{5, 7}}); 
        Matrix m2 = Matrix.of(new int[][] {{1, 566, 321}, {32, 4565, 0}});
        Matrix m3 = Matrix.of(new int[][] {{1}});
        Matrix m4 = Matrix.of(new int[][] {{2,3,-1,1}, {-3,2,0,3}, {3,-2,1,0}, {3, -2, 1, 4}});
        Matrix m5 = Matrix.of(new int[][] {{1, 2},{2, 4}});

        System.out.println(m1.findDeterminant()); // Determinant = 1
        // System.out.println(m2.findDeterminant()); // throws Error since not square matrix
        System.out.println(m3.findDeterminant()); // Determinant = 1
        System.out.println(m4.findDeterminant()); // Determinant = 52

        System.out.println(m1.toString());
        System.out.println(m2.toString());
        System.out.println(m3.toString());
    }
}