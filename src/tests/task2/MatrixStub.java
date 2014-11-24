package tests.task2;

import donnu.zolotarev.tpi.laba2.task2.IMatrix;

public class MatrixStub implements IMatrix {
    private boolean isUseDeterminant = false;

    @Override
    public double determinant(double[][] matrix) {
        isUseDeterminant = true;
        return 0;
    }

    public boolean isUseDeterminant() {
        return isUseDeterminant;
    }
}
