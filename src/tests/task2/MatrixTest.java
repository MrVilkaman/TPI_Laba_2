package tests.task2;

import donnu.zolotarev.tpi.laba2.task2.Matrix;
import org.junit.Assert;
import org.junit.Test;

public class MatrixTest  extends Assert{

    private static final double EPS = 0.001;

    @Test(expected = IllegalArgumentException.class)
    public void testMatrixIllegalArgumentException() {
        Matrix matrix = new Matrix(new double[][]{});

        matrix.determinant();
    }

    @Test()
    public void testMatrixSizeN1var1() {
        Matrix matrix = new Matrix(new double[][]{{1}});
        double res =  matrix.determinant();
        assertEquals(1,res,EPS);
    }

    @Test()
    public void testMatrixSizeN1var2() {
        Matrix matrix = new Matrix(new double[][]{{-15}});
        double res =  matrix.determinant();
        assertEquals(-15,res,EPS);
    }

    @Test()
    public void testMatrixSizeN2Var1() {
        Matrix matrix = new Matrix(new double[][]{
                {2,1} ,
                {1,2} ,
        });

        double res =  matrix.determinant();
        assertEquals(3,res,EPS);
    }

    @Test()
    public void testMatrixSizeN2Var2() {
        Matrix matrix = new Matrix(new double[][]{
                {15,1} ,
                {2,2} ,
        });

        double res =  matrix.determinant();
        assertEquals(28,res,EPS);
    }

    @Test()
      public void testMatrixSizeN3Var1() {
        Matrix matrix = new Matrix(new double[][]{
                {1,2,3} ,
                {3,2,1} ,
                {4,4,3} ,
        });

        double res =  matrix.determinant();
        assertEquals(4,res,EPS);
    }




    @Test()
    public void testMatrixSizeN3Var2() {
        Matrix matrix = new Matrix(new double[][]{
                {5,4,2} ,
                {2,1,2} ,
                {2,3,4} ,
        });

        double res =  matrix.determinant();
        assertEquals(-18,res,EPS);
    }

    @Test()
    public void testMatrixSizeN4Var1() {
        Matrix matrix = new Matrix(new double[][]{
                {1,	2,	3,	4},
                {4,	5,	2,	1},
                {3,	4,	1,	1},
                {8,	7,	1,	2}
        });

        double res =  matrix.determinant();
        assertEquals(39,res,EPS);
    }

    @Test()
    public void testMatrixSizeN4Var2() {
        Matrix matrix = new Matrix(new double[][]{
                {5,	2,	1,	9},
                {8,	7,	3,	1},
                {3,	5,	7,	1},
                {3,	1,	3,	1}
        });

        double res =  matrix.determinant();
        assertEquals(-908,res,EPS);
    }
}
