package donnu.zolotarev.tpi.laba2.task2;

public class LinearEquationsSystem {


    private final IMatrix iMatrix;
    private double[][] coeffs;

    public LinearEquationsSystem(IMatrix iMatrix) {
       this.iMatrix = iMatrix;
    }

    public  double[] solve(){
        if (coeffs.length == 0){
            throw new IllegalArgumentException();
        }

        double[] res = new double[coeffs.length];

        double det = iMatrix.determinant(getMatrix(0));
        if (det == 0){
            throw new RuntimeException();
        }

        for (int i = 1; i <= coeffs.length; i++) {
            double detX = iMatrix.determinant(getMatrix(i));
            if (detX == 0){
                throw new RuntimeException();
            }
            res[i-1] = detX/det;
        }

        return res;
    }

    public double[][] getMatrix(int index) {
        double[][] res = new double[coeffs.length][coeffs.length];

        for (int i = 0; i < coeffs.length; i++) {
            for (int j = 0; j < coeffs[0].length-1; j++) {
                res[i][j] = coeffs[i][j];
            }
        }

        if (index <0 || coeffs[0].length <index){
            throw new IllegalArgumentException();
        }

        if (index != 0){
            for (int j = 0; j < coeffs.length; j++) {
                res[j][index-1] = coeffs[j][coeffs[0].length-1];
            }
        }
       return res;
    }

    public void setCoefficients(double[][] coeffs){
        if (coeffs == null){
            throw new NullPointerException();
        }
        this.coeffs = coeffs;
    }
}
