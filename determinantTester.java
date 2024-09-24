public class determinantTester
{
    public static void main(String[] args) {
        Matrix m1 = Matrix.of(new int[][] {{3, 4},{5, 7}}); // Determinant = 1
        Matrix m2 = Matrix.of(new int[][] {{3, 4, 8},{5, 7, -9}, {9, 3, 5}}); // Determinant = -622
        System.out.println(m1.findDeterminant());
        System.out.println(m2.findDeterminant());
    }
}