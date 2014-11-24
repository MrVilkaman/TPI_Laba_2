package tests.task2;

import donnu.zolotarev.tpi.laba2.task2.Matrix;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class MatrixTest  extends Assert{

    private static final double EPS = 0.001;
    private static Matrix matrix;

    @BeforeClass()
    public static void setup(){
        matrix = new Matrix();
    }


    @Test(expected = IllegalArgumentException.class)
    public void testMatrixIllegalArgumentException() {
        matrix.determinant(new double[][]{});
    }

    @Test()
    public void testMatrixSizeN1var1() {
        double res =  matrix.determinant(new double[][]{{1}});
        assertEquals(1,res,EPS);
    }

    @Test()
    public void testMatrixSizeN1var2() {
        double res =  matrix.determinant(new double[][]{{-15}});
        assertEquals(-15,res,EPS);
    }

    @Test()
    public void testMatrixSizeN2Var1() {

        double res =  matrix.determinant(new double[][]{
                {2,1} ,
                {1,2} ,
        });
        assertEquals(3,res,EPS);
    }

    @Test()
    public void testMatrixSizeN2Var2() {

        double res =  matrix.determinant(new double[][]{
                {15,1} ,
                {2,2} ,
        });
        assertEquals(28,res,EPS);
    }

    @Test()
      public void testMatrixSizeN3Var1() {

        double res =  matrix.determinant(new double[][]{
                {1,2,3} ,
                {3,2,1} ,
                {4,4,3} ,
        });
        assertEquals(4,res,EPS);
    }

    @Test()
    public void testMatrixSizeN3Var2() {
        double res =  matrix.determinant(new double[][]{{5, 4, 2}, {2, 1, 2}, {2, 3, 4},});
        assertEquals(-18,res,EPS);
    }


    @Ignore
    @Test()
    public void testMatrixSizeN4Var1() {
        double res =  matrix.determinant(new double[][]{
                {1,	2,	3,	4},
                {4,	5,	2,	1},
                {3,	4,	1,	1},
                {8,	7,	1,	2}
        });
        assertEquals(39,res,EPS);
    }

    @Ignore
    @Test()
    public void testMatrixSizeN4Var2() {
        Matrix matrix = new Matrix();

        double res =  matrix.determinant(new double[][]{
                {5,	2,	1,	9},
                {8,	7,	3,	1},
                {3,	5,	7,	1},
                {3,	1,	3,	1}
        });
        assertEquals(-908,res,EPS);
    }
}
