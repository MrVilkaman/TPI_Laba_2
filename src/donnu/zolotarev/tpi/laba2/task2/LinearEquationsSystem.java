package donnu.zolotarev.tpi.laba2.task2;

public class LinearEquationsSystem {


    private final IMatrix iMatrix;
    private double[][] coeffs;

    public LinearEquationsSystem(IMatrix iMatrix) {
       this.iMatrix = iMatrix;
    }

    public  double[] solve(){
        double det = iMatrix.determinant();
        if (det == 0){
            throw new RuntimeException();
        }
        return null;
    }

    public void setCoefficients(double[][] coeffs){
        if (coeffs == null){
            throw new NullPointerException();
        }
        this.coeffs = coeffs;
    }
}
