package donnu.zolotarev.tpi.laba2.task2;

public class Matrix implements IMatrix {
    private final double[][] matrix;
    private final static double Eps = 10E-6;

    @Override
    public double determinant() {
        for (int i = 0; i < matrix.length; i++) {
           if (Math.abs(matrix[i][i]) < Eps ){
               return 0;
           }

        }

        return 0;
    }

    public Matrix(double[][] matrix) {
         this.matrix = matrix;
    }


}
