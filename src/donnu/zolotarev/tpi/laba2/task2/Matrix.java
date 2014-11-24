package donnu.zolotarev.tpi.laba2.task2;

public class Matrix implements IMatrix {
    private final static double Eps = 10E-6;

    @Override
    public double determinant(double[][] matrix) {
        if (matrix.length == 0 ||matrix.length != matrix[0].length){
            throw new IllegalArgumentException();
        }

        switch (matrix.length){
            case 1:
                return matrix[0][0];
            case 2:
                return getDeterminantFormLength2(matrix);
            case 3:
                return getDeterminantFormLength3(matrix);
        }


        return 0;
    }

   /* private double getDeterminantFormLength4(double[][] matrix) {
        return matrix[0][0]*getDeterminantFormLength3(getLineWithout(matrix[0],0))+
                matrix[0][1]*getDeterminantFormLength3()+
                matrix[0][2]*getDeterminantFormLength3()+
                matrix[0][3]*getDeterminantFormLength3();
    }

*/
    private double getDeterminantFormLength3(double[][] matrix) {
        return matrix[0][0]*matrix[1][1]*matrix[2][2] + matrix[0][1]*matrix[1][2]*matrix[2][0]
                +matrix[0][2]*matrix[1][0]*matrix[2][1] - matrix[0][2]*matrix[1][1]*matrix[2][0]
                - matrix[0][0]*matrix[1][2]*matrix[2][1] - matrix[0][1]*matrix[1][0]*matrix[2][2];

    }

    private double getDeterminantFormLength2(double[][] matrix) {
        return matrix[0][0]*matrix[1][1] - matrix[0][1]*matrix[1][0];
    }

}
