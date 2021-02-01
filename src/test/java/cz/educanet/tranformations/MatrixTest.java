package cz.educanet.tranformations;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MatrixTest {

    private IMatrix a;
    private IMatrix b;
    private IMatrix c;
    private IMatrix d;
    private IMatrix e;
    private IMatrix empty;

    @Before
    public void setUp() throws Exception {
        double[][] rawA = {
                {1, 1, 1},
                {1, 1, 1},
        };
        a = MatrixFactory.create(rawA);

        double[][] rawB = {
                {1, 1, 1},
                {1, 1, 1},
                {0, 0, 0},
        };
        b = MatrixFactory.create(rawB);
        double[][] rawC = {
                {1, 0, 0},
                {0, 1, 0},
                {0, 0, 1},
        };
        c = MatrixFactory.create(rawC);

        double[][] rawEmpty = {};
        empty = MatrixFactory.create(rawEmpty);

        double[][] rawD = {
                {1, 1}
        };
        d = MatrixFactory.create(rawD);

        double[][] rawE = {
                {1, 2},
                {3, 4},
                {5, 6}
        };
        e = MatrixFactory.create(rawE);
    }

    @Test
    public void getRows() {
        assertEquals(2, a.getRows());
        assertEquals(3, b.getRows());
        assertEquals(3, c.getRows());
        assertEquals(0, empty.getRows());
    }

    @Test
    public void getColumns() {
        assertEquals(3, a.getColumns());
        assertEquals(3, b.getColumns());
        assertEquals(3, c.getColumns());
        assertEquals(0, empty.getColumns());
        assertEquals(2, d.getColumns());
    }

    @Test
    public void times() {
        double[][] timesAE = {
                {9, 12},
                {9,12}
        };
        double[][] timesEA = {
                {3, 3, 3},
                {7, 7, 7},
                {11, 11, 11}
        };

        assertEquals(MatrixFactory.create(timesAE), (a.times(e)));
        assertEquals(MatrixFactory.create(timesEA), (e.times(a)));

    }

    @Test
    public void timesScalar() {
        double[][] timesAX = {
                {2, 2, 2},
                {2, 2, 2}
        };

        assertEquals(MatrixFactory.create(timesAX), a.times(2));
    }

    @Test
    public void add() {
        double[][] addBC = {
                {2, 1, 1},
                {1, 2, 1},
                {0, 0, 1}
        };

        assertEquals(MatrixFactory.create(addBC), b.add(c));
    }

    @Test
    public void get() {
    }

    @Test
    public void transpose() {
        double[][] transposeB = {
                {1, 1, 0},
                {1, 1, 0},
                {1, 1, 0}
        };
        
        assertEquals(MatrixFactory.create(transposeB), b.transpose());
    }

    @Test
    public void determinant() {
    }
}
